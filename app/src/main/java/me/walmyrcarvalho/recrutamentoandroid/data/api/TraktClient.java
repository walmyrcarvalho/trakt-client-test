package me.walmyrcarvalho.recrutamentoandroid.data.api;

import android.support.annotation.NonNull;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.api.callback.ShowInfoCallback;
import me.walmyrcarvalho.recrutamentoandroid.data.api.callback.ShowSeasonCallback;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Episode;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Show;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TraktClient {

    public void loadShowSeason(String showName, String season, @NonNull final ShowSeasonCallback callback) {
        TraktAPI.getInstance().getShowSeason(showName, season).enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                List<Episode> episodes = response.body();
                if (episodes != null) {
                    callback.onShowSeasonLoaded(episodes);
                } else {
                    callback.onShowSeasonNotLoaded("There's no season available.");
                }
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {
                callback.onShowSeasonNotLoaded("There's no season available.");
            }
        });
    }

    public void loadShowInfo(String showName, @NonNull final ShowInfoCallback callback) {
        TraktAPI.getInstance().getShowInfo(showName).enqueue(new Callback<Show>() {
            @Override
            public void onResponse(Call<Show> call, Response<Show> response) {
                Show show = response.body();
                if (show != null) {
                    callback.onShowInfoLoaded(show);
                } else {
                    callback.onShowInfoNotLoaded("There's no show available.");
                }
            }

            @Override
            public void onFailure(Call<Show> call, Throwable t) {
                callback.onShowInfoNotLoaded("There's no show available.");
            }
        });

    }
}
