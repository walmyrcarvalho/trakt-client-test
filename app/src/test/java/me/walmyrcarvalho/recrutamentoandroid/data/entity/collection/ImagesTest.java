package me.walmyrcarvalho.recrutamentoandroid.data.entity.collection;

import org.junit.Before;
import org.junit.Test;

import me.walmyrcarvalho.recrutamentoandroid.data.entity.Image;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ImagesTest {

    public static final String EXPECTED_POSTER_URL = "https://walter.trakt.us/images/shows/000/093/720/posters/original/e90844dd99.jpg";
    public static final String EXPECTED_BANNER_URL = "https://walter.trakt.us/images/shows/000/093/720/banners/original/1df32e4211.jpg";

    private Images images;
    private Image poster, banner;

    @Before
    public void setupModel() {
        poster = new Image("https://walter.trakt.us/images/shows/000/093/720/posters/original/e90844dd99.jpg");
        banner = new Image("https://walter.trakt.us/images/shows/000/093/720/banners/original/1df32e4211.jpg");

        images = new Images(poster, banner);
    }

    @Test
    public void testNewObjectNotNull() {
        assertNotNull(images);
    }

    @Test
    public void testImagesInfo() {
        assertEquals(EXPECTED_POSTER_URL, poster.url);
        assertEquals(EXPECTED_BANNER_URL, banner.url);

        assertEquals(images.poster, poster);
        assertEquals(images.banner, banner);
    }

}
