package me.walmyrcarvalho.recrutamentoandroid.ui.screens.season;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.model.Episode;

public interface SeasonDetailContract {

    void showResult(List<Episode> episodes);

    void showProgress(boolean active);

    void showError(String error);

}
