package me.walmyrcarvalho.recrutamentoandroid.data.api;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.model.Season;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Show;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TraktService {

    @GET("shows/{title}")
    Call<Show> getShow(@Path("id") String title);

    @GET("shows/{title}/seasons")
    Call<List<Season>> getShowSeasons(@Path("id") String title);

    @GET("shows/{title}/seasons/{id}")
    Call<Season> getShowSeason(@Path("title") String title, int id);
}
