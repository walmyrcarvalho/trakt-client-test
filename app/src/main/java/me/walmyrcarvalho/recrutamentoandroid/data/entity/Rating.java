package me.walmyrcarvalho.recrutamentoandroid.data.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Rating {
    public BigDecimal rating;

    public String getPrettyRating() {
        DecimalFormat ratingFormat = new DecimalFormat("#.#");
        ratingFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        return ratingFormat.format(rating);
    }
}
