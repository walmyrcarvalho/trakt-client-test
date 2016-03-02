package me.walmyrcarvalho.recrutamentoandroid.ui.screen.seasondetail;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.api.TraktClient;
import me.walmyrcarvalho.recrutamentoandroid.data.api.callback.ShowInfoCallback;
import me.walmyrcarvalho.recrutamentoandroid.data.api.callback.ShowSeasonCallback;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Episode;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Show;

import static me.walmyrcarvalho.recrutamentoandroid.util.Preconditions.checkNotNull;

public class SeasonDetailPresenter implements
        SeasonDetailContract.Actions, ShowSeasonCallback, ShowInfoCallback {

    private SeasonDetailContract.View view;
    private TraktClient client;

    public SeasonDetailPresenter(TraktClient client, SeasonDetailContract.View view) {
        this.view = checkNotNull(view, "SeasonDetailContract.View cannot be null.");
        this.client = checkNotNull(client, "TraktClient cannot be null.");
    }

    @Override
    public void loadShowSeason(String showName, String season) {
        if (view != null) {
            view.showProgress();
        }
        client.loadShowSeason(showName, season, this);
    }

    @Override
    public void loadShowInfo(String showName) {
        client.loadShowInfo(showName, this);
    }

    @Override
    public void onDestroyView() {
        view = null;
    }

    @Override
    public void onShowSeasonLoaded(List<Episode> episodes) {
        if (view != null) {
            view.hideProgress();
            view.loadShowSeason(episodes);
        }
    }

    @Override
    public void onShowSeasonNotLoaded(String errorMessage) {
        if (view != null) {
            view.hideProgress();
            view.showError(errorMessage);
        }
    }

    @Override
    public void onShowInfoLoaded(Show show) {
        if (view != null) {
            view.loadShowInfo(show);
        }
    }

    @Override
    public void onShowInfoNotLoaded(String errorMessage) {
        if (view != null) {
            view.showError(errorMessage);
        }
    }
}
