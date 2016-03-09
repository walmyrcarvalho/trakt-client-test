package me.walmyrcarvalho.recrutamentoandroid.data.api.callback;

import me.walmyrcarvalho.recrutamentoandroid.data.entity.Rating;

public interface ShowRatingCallback {

    void onShowRatingLoaded(Rating rating);

    void onShowRatingNotLoaded(String errorMessage);
}
