package me.walmyrcarvalho.recrutamentoandroid.data.entity;

import me.walmyrcarvalho.recrutamentoandroid.data.entity.collection.Images;

public class Show {
    public String title;
    public Images images;

    public Show(String title, Images images) {
        this.title = title;
        this.images = images;
    }
}
