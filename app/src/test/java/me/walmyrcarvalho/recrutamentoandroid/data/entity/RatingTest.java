package me.walmyrcarvalho.recrutamentoandroid.data.entity;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class RatingTest {

    public static final BigDecimal EXPECTED_RATING = new BigDecimal("8.86204");
    public static final String EXPECTED_PRETTY_RATING = "8.9";

    private Rating rating;

    @Before
    public void setupModel() {
        rating = new Rating(BigDecimal.valueOf(8.86204));
    }

    @Test
    public void testNewObjectNotNull() {
        assertNotNull(rating);
    }

    @Test
    public void testRatingInfo() {
        assertEquals(EXPECTED_RATING, rating.rating);
    }

    @Test
    public void testPrettyRating() {
        assertEquals(EXPECTED_PRETTY_RATING, rating.getPrettyRating());
    }

}
