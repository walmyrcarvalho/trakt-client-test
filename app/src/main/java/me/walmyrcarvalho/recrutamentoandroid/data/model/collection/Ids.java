package me.walmyrcarvalho.recrutamentoandroid.data.model.collection;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Ids {
    public int trakt, tvdb, tmdb, tvrage;

    public String imdb, slug;

    @ParcelConstructor
    public Ids() { /**/ }
}
