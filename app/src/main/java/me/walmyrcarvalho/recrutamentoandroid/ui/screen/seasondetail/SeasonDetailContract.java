package me.walmyrcarvalho.recrutamentoandroid.ui.screen.seasondetail;

import android.support.v7.widget.Toolbar;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.model.Episode;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Season;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Show;

public interface SeasonDetailContract {

    interface View {
        void loadShowInfo(Show show);

        void loadShowSeason(List<Episode> episodes);

        void showProgress();

        void hideProgress();

        void showContent();

        void hideContent();

        void showError(String error);
    }

    interface Actions {
        void loadShowSeason(String showName, String season);

        void loadShowInfo(String showName);

        void onDestroyView();
    }
}
