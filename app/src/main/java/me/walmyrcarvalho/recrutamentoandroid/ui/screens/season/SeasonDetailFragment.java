package me.walmyrcarvalho.recrutamentoandroid.ui.screens.season;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.walmyrcarvalho.recrutamentoandroid.R;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Episode;

public class SeasonDetailFragment extends Fragment implements SeasonDetailContract {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    public SeasonDetailFragment() { /**/ }

    public static SeasonDetailFragment newInstance() {
        return new SeasonDetailFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_season_detail, container, false);

        ButterKnife.bind(this, view);

        setupToolbar(toolbar);

        return view;
    }

    private void setupToolbar(Toolbar toolbar) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Season 1");
    }

    @Override
    public void showResult(List<Episode> episodes) {

    }

    @Override
    public void showProgress(boolean active) {

    }

    @Override
    public void showError(String error) {

    }
}
