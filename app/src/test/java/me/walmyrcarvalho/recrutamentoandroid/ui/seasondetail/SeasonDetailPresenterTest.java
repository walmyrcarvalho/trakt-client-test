package me.walmyrcarvalho.recrutamentoandroid.ui.seasondetail;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import me.walmyrcarvalho.recrutamentoandroid.data.api.TraktClient;

import static junit.framework.Assert.assertNotNull;

/**
 * Describe your class here
 *
 * @author Walmyr Carvalho
 **/
public class SeasonDetailPresenterTest {

    @Mock
    private SeasonDetailContract.View view;

    @Mock
    private TraktClient client;

    private SeasonDetailPresenter presenter;

    @Before
    public void setupSeasonDetailPresenter() {
        MockitoAnnotations.initMocks(this);

        presenter = new SeasonDetailPresenter(client, view);
    }

    @Test
    public void testPresenterNotNull() {
        assertNotNull(presenter);
    }
}
