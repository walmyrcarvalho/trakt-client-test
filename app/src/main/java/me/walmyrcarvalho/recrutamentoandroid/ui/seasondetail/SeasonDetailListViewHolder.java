package me.walmyrcarvalho.recrutamentoandroid.ui.seasondetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.walmyrcarvalho.recrutamentoandroid.R;

public class SeasonDetailListViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.episode_number)
    public TextView episodeNumber;

    @Bind(R.id.episode_title)
    public TextView episodeTitle;

    public SeasonDetailListViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }
}
