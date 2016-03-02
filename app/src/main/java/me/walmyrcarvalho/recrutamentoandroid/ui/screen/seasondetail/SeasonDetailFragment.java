package me.walmyrcarvalho.recrutamentoandroid.ui.screen.seasondetail;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.walmyrcarvalho.recrutamentoandroid.R;
import me.walmyrcarvalho.recrutamentoandroid.data.api.TraktClient;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Episode;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Show;
import me.walmyrcarvalho.recrutamentoandroid.ui.adapter.SeasonDetailListAdapter;
import me.walmyrcarvalho.recrutamentoandroid.util.Constants;
import me.walmyrcarvalho.recrutamentoandroid.util.NetworkUtil;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class SeasonDetailFragment extends Fragment implements SeasonDetailContract.View {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.progress_bar)
    MaterialProgressBar progressBar;

    @Bind(R.id.recyclerview)
    RecyclerView list;

    @Bind(R.id.season_poster)
    ImageView poster;

    @Bind(R.id.banner)
    ImageView banner;

    private View view;
    private SeasonDetailListAdapter adapter;

    private SeasonDetailContract.Actions actionsListener;

    public SeasonDetailFragment() { /**/ }

    public static SeasonDetailFragment newInstance() {
        return new SeasonDetailFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);

        if (NetworkUtil.isNetworkConnected(getActivity())) {
            actionsListener = new SeasonDetailPresenter(new TraktClient(), this);
            actionsListener.loadShowSeason(Constants.SHOW_NAME, Constants.SHOW_SEASON);
            actionsListener.loadShowInfo(Constants.SHOW_NAME);
        } else {
            showError("Você está sem internet, verifique sua conexão e tente novamente.");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_season_detail, container, false);

        ButterKnife.bind(this, view);

        setupToolbar(toolbar);
        setupRecyclerView(container.getContext(), list);

        return view;
    }

    private void setupRecyclerView(Context context, RecyclerView list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(layoutManager);
        list.setNestedScrollingEnabled(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (actionsListener != null) {
            actionsListener.onDestroyView();
        }
    }

    private void setupToolbar(Toolbar toolbar) {
        toolbar.setTitle("Detalhes da temporada");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    @Override
    public void loadShowInfo(Show show) {

    }

    @Override
    public void loadShowSeason(List<Episode> episodes) {
        if (adapter == null) {
            adapter = new SeasonDetailListAdapter(episodes);
            list.setAdapter(adapter);
        } else {
            adapter.updateList(episodes);
        }
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
    public void showContent() {

    }

    @Override
    public void hideContent() {

    }

    @Override
    public void showError(String error) {
        Snackbar.make(view, error, Snackbar.LENGTH_SHORT).show();
    }
}
