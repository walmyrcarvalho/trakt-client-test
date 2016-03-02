package me.walmyrcarvalho.recrutamentoandroid.data.api.callback;

import me.walmyrcarvalho.recrutamentoandroid.data.model.Show;

public interface ShowInfoCallback {

    void onShowInfoLoaded(Show show);

    void onShowInfoNotLoaded(String error);
}
