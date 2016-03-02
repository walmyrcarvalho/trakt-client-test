package me.walmyrcarvalho.recrutamentoandroid.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.walmyrcarvalho.recrutamentoandroid.R;

public class SeasonDetailViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.list_item_drawable)
    public ImageView listDrawable;

    @Bind(R.id.list_item_title)
    public TextView listTitle;

    public SeasonDetailViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }
}
