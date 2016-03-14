package me.walmyrcarvalho.recrutamentoandroid.ui.seasondetail;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.walmyrcarvalho.recrutamentoandroid.R;
import me.walmyrcarvalho.recrutamentoandroid.data.api.TraktClient;
import me.walmyrcarvalho.recrutamentoandroid.data.entity.Episode;
import me.walmyrcarvalho.recrutamentoandroid.misc.util.Constants;
import me.walmyrcarvalho.recrutamentoandroid.misc.util.NetworkUtil;
import me.walmyrcarvalho.recrutamentoandroid.misc.widgets.DividerItemDecoration;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class SeasonDetailFragment extends Fragment implements SeasonDetailContract.View {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.progress_bar)
    MaterialProgressBar progressBar;

    @Bind(R.id.recyclerview)
    RecyclerView episodesList;

    @Bind(R.id.season_poster)
    ImageView posterImage;

    @Bind(R.id.season_header)
    ImageView headerImage;

    @Bind(R.id.season_rating)
    TextView seasonRating;

    private View view;
    private SeasonDetailPresenter presenter;

    public SeasonDetailFragment() { /**/ }

    public static SeasonDetailFragment newInstance() {
        return new SeasonDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundleState) {
        view = inflater.inflate(R.layout.fragment_season_detail, container, false);

        ButterKnife.bind(this, view);

        setRetainInstance(true);
        setHasOptionsMenu(true);

        setupToolbar();
        setupPresenter();
        setupRecyclerView(container.getContext(), episodesList);

        loadData(getActivity());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_season_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_refresh:
                loadData(getActivity());
                return true;

            case R.id.menu_about:
                showAboutDialog();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.dettachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    private void setupToolbar() {
        toolbar.setTitle("Season 1");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    private void setupPresenter() {
        presenter = new SeasonDetailPresenter(new TraktClient(), this);
    }

    private void setupRecyclerView(Context context, RecyclerView list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(list.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setAutoMeasureEnabled(true);

        list.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        list.setLayoutManager(layoutManager);
        list.setNestedScrollingEnabled(false);
    }

    private void loadData(Context context) {
        if (NetworkUtil.isNetworkConnected(context)) {
            presenter.loadShowSeason(Constants.SHOW_NAME, Constants.SHOW_SEASON);
            presenter.loadShowDetail(Constants.SHOW_NAME);
            presenter.loadShowRating(Constants.SHOW_NAME);
        } else {
            showError(context.getString(R.string.network_error));
        }
    }

    @Override
    public void showSeasonEpisodes(List<Episode> episodes) {
        SeasonDetailListAdapter adapter = new SeasonDetailListAdapter(episodes);
        adapter.updateList(episodes);
        episodesList.setAdapter(adapter);
    }

    @Override
    public void showHeaderImage(String headerUrl) {
        Picasso.with(getActivity())
                .load(headerUrl)
                .into(headerImage);
    }

    @Override
    public void showPosterImage(String posterUrl) {
        Picasso.with(getActivity())
                .load(posterUrl)
                .placeholder(R.drawable.poster_placeholder)
                .into(posterImage);
    }

    @Override
    public void showRating(String showRating) {
        seasonRating.setText(showRating);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Snackbar.make(view, error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showAboutDialog() {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.app_dialog_title)
                .setMessage(R.string.app_dialog_description)
                .setNeutralButton(R.string.close, null)
                .create();

        dialog.show();
    }
}
