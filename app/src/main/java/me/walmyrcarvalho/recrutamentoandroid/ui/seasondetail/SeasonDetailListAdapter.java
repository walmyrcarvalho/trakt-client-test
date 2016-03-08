package me.walmyrcarvalho.recrutamentoandroid.ui.seasondetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import me.walmyrcarvalho.recrutamentoandroid.R;
import me.walmyrcarvalho.recrutamentoandroid.data.entity.Episode;

import static me.walmyrcarvalho.recrutamentoandroid.misc.util.Preconditions.checkNotNull;

public class SeasonDetailListAdapter extends RecyclerView.Adapter<SeasonDetailListViewHolder> {

    private List<Episode> episodes;

    public SeasonDetailListAdapter(List<Episode> episodes) {
        setEpisodes(episodes);
    }

    @Override
    public SeasonDetailListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_episode_list_item, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Episode clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return new SeasonDetailListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeasonDetailListViewHolder holder, int position) {
        Episode episode = episodes.get(position);

        holder.episodeTitle.setText(episode.title);
        holder.episodeNumber.setText(String.format(Locale.US, "E%d", episode.number));
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = checkNotNull(episodes);
    }

    public void updateList(List<Episode> episodes) {
        setEpisodes(episodes);
    }
}
