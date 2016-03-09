package me.walmyrcarvalho.recrutamentoandroid.data.api;

import android.support.annotation.NonNull;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.api.callback.ShowDetailCallback;
import me.walmyrcarvalho.recrutamentoandroid.data.api.callback.ShowRatingCallback;
import me.walmyrcarvalho.recrutamentoandroid.data.api.callback.ShowSeasonCallback;
import me.walmyrcarvalho.recrutamentoandroid.data.entity.Episode;
import me.walmyrcarvalho.recrutamentoandroid.data.entity.Rating;
import me.walmyrcarvalho.recrutamentoandroid.data.entity.Show;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TraktClient {

    public void loadShowSeason(String showName, int season, @NonNull final ShowSeasonCallback callback) {

        TraktAPI.getInstance()
                .getShowSeason(showName, season)
                .enqueue(new Callback<List<Episode>>() {

                    @Override
                    public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                        List<Episode> episodes = response.body();
                        if (episodes != null) {
                            callback.onShowSeasonLoaded(episodes);
                        } else {
                            callback.onShowSeasonNotLoaded("Unable to find the season.");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Episode>> call, Throwable t) {
                        callback.onShowSeasonNotLoaded("Unable to find the season.");
                    }
                });
    }

    public void loadShowDetail(String showName, @NonNull final ShowDetailCallback callback) {

        TraktAPI.getInstance()
                .getShowDetail(showName)
                .enqueue(new Callback<Show>() {

                    @Override
                    public void onResponse(Call<Show> call, Response<Show> response) {
                        Show show = response.body();
                        if (show != null) {
                            callback.onShowDetailLoaded(show);
                        } else {
                            callback.onShowDetailNotLoaded("Unable to find the show.");
                        }
                    }

                    @Override
                    public void onFailure(Call<Show> call, Throwable t) {
                        callback.onShowDetailNotLoaded("Unable to find the show.");
                    }
                });

    }

    public void loadShowRating(String showName, @NonNull final ShowRatingCallback callback) {

        TraktAPI.getInstance()
                .getShowRating(showName)
                .enqueue(new Callback<Rating>() {
                    @Override
                    public void onResponse(Call<Rating> call, Response<Rating> response) {
                        Rating rating = response.body();
                        if (rating != null) {
                            callback.onShowRatingLoaded(rating);
                        } else {
                            callback.onShowRatingNotLoaded("Unable to find the show rating.");
                        }
                    }

                    @Override
                    public void onFailure(Call<Rating> call, Throwable t) {
                        callback.onShowRatingNotLoaded("Unable to find the show rating.");
                    }
                });
    }
}
