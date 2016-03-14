package me.walmyrcarvalho.recrutamentoandroid.data.api;

import com.google.gson.Gson;

import java.io.IOException;

import me.walmyrcarvalho.recrutamentoandroid.BuildConfig;
import me.walmyrcarvalho.recrutamentoandroid.misc.util.Constants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

public class TraktAPI {

    private static TraktAPI api;
    private TraktService service;

    public static TraktService getInstance() {
        if (api == null) {
            api = new TraktAPI();
        }
        return api.getService();
    }

    public TraktAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .baseUrl(Constants.BASE_URL)
                .client(getOkHttpClient())
                .build();

        service = retrofit.create(TraktService.class);
    }

    public OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public TraktService getService() {
        return service;
    }

    public static HttpLoggingInterceptor httpLoggingInterceptor =
            new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? BODY : NONE);

    public static Interceptor headerInterceptor = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .header(Constants.HEADER_CONTENT_TYPE, Constants.VALUE_CONTENT_TYPE)
                    .header(Constants.HEADER_API_KEY, Constants.VALUE_API_KEY)
                    .header(Constants.HEADER_API_VERSION, Constants.VALUE_API_VERSION)
                    .build();

            return chain
                    .proceed(request)
                    .newBuilder()
                    .build();
        }
    };
}
