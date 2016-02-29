package me.walmyrcarvalho.recrutamentoandroid.data.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.List;

@Parcel
public class Season {
    public List<Episode> episodes;

    @ParcelConstructor
    public Season() { /**/ }
}
