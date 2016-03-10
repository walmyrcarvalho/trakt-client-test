package me.walmyrcarvalho.recrutamentoandroid.data.entity;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("full")
    public String url;

    public Image(String url) {
        this.url = url;
    }
}
