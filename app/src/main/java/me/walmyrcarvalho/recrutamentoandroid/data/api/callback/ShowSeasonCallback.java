package me.walmyrcarvalho.recrutamentoandroid.data.api.callback;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.model.Episode;

public interface ShowSeasonCallback {

    void onShowSeasonLoaded(List<Episode> episodes);

    void onShowSeasonNotLoaded(String errorMessage);
}
