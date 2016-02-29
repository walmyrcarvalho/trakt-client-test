package me.walmyrcarvalho.recrutamentoandroid.data.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import me.walmyrcarvalho.recrutamentoandroid.data.model.collections.Ids;

@Parcel
public class Episode {
    public int season, number;

    public String title;
    public Ids ids;

    @ParcelConstructor
    public Episode() { /**/ }
}
