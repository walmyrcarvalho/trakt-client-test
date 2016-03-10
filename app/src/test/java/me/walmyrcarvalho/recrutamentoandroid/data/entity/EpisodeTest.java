package me.walmyrcarvalho.recrutamentoandroid.data.entity;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EpisodeTest {

    public static final int EXPECTED_NUMBER = 1;
    public static final String EXPECTED_TITLE = "Winter is coming";

    private Episode episode;

    @Before
    public void setupModel() throws Exception {
        episode = new Episode(1, "Winter is coming");
    }

    @Test
    public void testNewObjectNotNull() {
        assertNotNull(episode);
    }

    @Test
    public void testEpisodeInfo() {
        assertEquals(EXPECTED_NUMBER, episode.number);
        assertEquals(EXPECTED_TITLE, episode.title);
    }
}
