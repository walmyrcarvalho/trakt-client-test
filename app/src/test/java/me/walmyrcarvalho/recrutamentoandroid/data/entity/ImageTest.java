package me.walmyrcarvalho.recrutamentoandroid.data.entity;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ImageTest {

    public static final String EXPECTED_URL = "https://walter.trakt.us/images/shows/000/093/720/posters/original/e90844dd99.jpg";

    private Image image;

    @Before
    public void setupModel() throws Exception {
        image = new Image("https://walter.trakt.us/images/shows/000/093/720/posters/original/e90844dd99.jpg");
    }

    @Test
    public void testNewObjectNotNull() {
        assertNotNull(image);
    }

    @Test
    public void testImageInfo() {
        assertEquals(EXPECTED_URL, image.url);
    }

}
