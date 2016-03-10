package me.walmyrcarvalho.recrutamentoandroid.data.entity;

import org.junit.Before;
import org.junit.Test;

import me.walmyrcarvalho.recrutamentoandroid.data.entity.collection.Images;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ShowTest {

    public static final String EXPECTED_POSTER_URL = "https://walter.trakt.us/images/shows/000/093/720/posters/original/e90844dd99.jpg";
    public static final String EXPECTED_BANNER_URL = "https://walter.trakt.us/images/shows/000/093/720/banners/original/1df32e4211.jpg";

    private static final String EXPECTED_TITLE = "Mr. Robot";

    private Show show;
    private Image poster, banner;
    private String title;

    private Images images;

    @Before
    public void setupTest() {
        poster = new Image("https://walter.trakt.us/images/shows/000/093/720/posters/original/e90844dd99.jpg");
        banner = new Image("https://walter.trakt.us/images/shows/000/093/720/banners/original/1df32e4211.jpg");

        title = "Mr. Robot";

        images = new Images(poster, banner);

        show = new Show(title, images);
    }

    @Test
    public void testNewObjectNotNull() {
        assertNotNull(show);
    }

    @Test
    public void testShowInfo() {
        assertEquals(EXPECTED_TITLE, show.title);
        assertEquals(EXPECTED_POSTER_URL, show.images.poster.url);
        assertEquals(EXPECTED_BANNER_URL, show.images.banner.url);
    }

}
