package me.walmyrcarvalho.recrutamentoandroid.misc.util;

import me.walmyrcarvalho.recrutamentoandroid.BuildConfig;

public class Constants {

    public static final String BASE_URL            = "https://api-v2launch.trakt.tv";

    public static final String SHOW_NAME           = "mr-robot";
    public static final int    SHOW_SEASON         = 1;

    public static final String HEADER_API_KEY      = "trakt-api-key";
    public static final String HEADER_API_VERSION  = "trakt-api-version";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";

    public static final String VALUE_API_KEY       = BuildConfig.API_KEY;
    public static final String VALUE_API_VERSION   = "2";
    public static final String VALUE_CONTENT_TYPE  = "application/json";
}
