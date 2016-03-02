package me.walmyrcarvalho.recrutamentoandroid.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import me.walmyrcarvalho.recrutamentoandroid.R;
import me.walmyrcarvalho.recrutamentoandroid.data.model.Episode;
import me.walmyrcarvalho.recrutamentoandroid.ui.viewholder.SeasonDetailViewHolder;

import static me.walmyrcarvalho.recrutamentoandroid.util.Preconditions.checkNotNull;

public class SeasonDetailListAdapter extends RecyclerView.Adapter<SeasonDetailViewHolder> {

    private List<Episode> episodes;

    public SeasonDetailListAdapter(List<Episode> episodes) {
        setEpisodes(episodes);
    }

    @Override
    public SeasonDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list_item, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Episode clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return new SeasonDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeasonDetailViewHolder holder, int position) {
        Episode episode = episodes.get(position);

        holder.listTitle.setText(episode.title);
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
        notifyDataSetChanged();
    }
}
