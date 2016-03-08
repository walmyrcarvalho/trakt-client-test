package me.walmyrcarvalho.recrutamentoandroid.data.api.callback;

import me.walmyrcarvalho.recrutamentoandroid.data.entity.Show;

public interface ShowDetailCallback {

    void onShowDetailLoaded(Show show);

    void onShowDetailNotLoaded(String error);
}
