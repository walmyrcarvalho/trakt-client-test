package me.walmyrcarvalho.recrutamentoandroid.data.api;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.model.Episode;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Season;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Show;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface TraktService {

    @GET("/shows/{title}?extended=images")
    Call<Show> getShowInfo(@Path("title") String title);

    @GET("/shows/{title}/seasons/{season}?")
    Call<List<Episode>> getShowSeason(@Path("title") String title,
                                      @Path("season") String season);
}
