package me.walmyrcarvalho.recrutamentoandroid.misc.util;

import me.walmyrcarvalho.recrutamentoandroid.BuildConfig;

public class Constants {

    public static final String BASE_URL            = "https://api-v2launch.trakt.tv";

    public static final String SHOW_NAME           = "mr-robot";
    public static final int    SHOW_SEASON         = 1;

    public static final String HEADER_API_KEY      = "trakt-api-key";
    public static final String HEADER_API_VERSION  = "trakt-api-version";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";

    // NOTE: This is not the ideal approach for saving API keys on Android. Almost no one is safe,
    // but there's some ways to make it hard to get like have a custom .so or use NDK.

    public static final String VALUE_API_KEY       = BuildConfig.API_KEY;
//    public static final String VALUE_API_KEY       = "3d6382af88e858392b7e1d2aab95fffbb941756452abd42977463c809bbbf36e";
    public static final String VALUE_API_VERSION   = "2";
    public static final String VALUE_CONTENT_TYPE  = "application/json";

}
