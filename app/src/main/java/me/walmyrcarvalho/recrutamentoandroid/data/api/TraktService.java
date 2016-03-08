package me.walmyrcarvalho.recrutamentoandroid.data.api;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.entity.Episode;
import me.walmyrcarvalho.recrutamentoandroid.data.entity.Show;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TraktService {

    @GET("/shows/{title}?extended=images")
    Call<Show> getShowDetail(@Path("title") String title);

    @GET("/shows/{title}/seasons/{season}?")
    Call<List<Episode>> getShowSeason(@Path("title") String title,
                                      @Path("season") int season);
}
