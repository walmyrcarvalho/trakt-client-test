package me.walmyrcarvalho.recrutamentoandroid.ui.seasondetail;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.entity.Episode;

public interface SeasonDetailContract {

    interface View {
        void showSeasonEpisodes(List<Episode> episodes);

        void showHeaderImage(String headerUrl);

        void showPosterImage(String posterUrl);

        void showRate(String showRating);

        void showError(String error);

        void showAboutDialog();

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void loadShowSeason(String showName, int season);

        void loadShowDetail(String showName);

        void attachView(View view);

        void dettachView();
    }
}
