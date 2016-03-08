package me.walmyrcarvalho.recrutamentoandroid.ui.seasondetail;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.data.entity.Episode;

public interface SeasonDetailContract {

    interface View {
        void loadShowSeason(List<Episode> episodes);

        void loadShowHeader(String headerUrl);

        void loadShowPoster(String posterUrl);

        void loadShowRate(String showRating);

        void showProgress();

        void hideProgress();

        void showError(String error);
    }

    interface Presenter {
        void loadShowSeason(String showName, int season);

        void loadShowDetail(String showName);

        void attachView(View view);

        void dettachView();
    }
}
