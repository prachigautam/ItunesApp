package com.prachigautam.itunesapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by amar on 01-08-2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    List<MusicPojo.Results> resultsList;
    Context context;

    public MusicAdapter(List<MusicPojo.Results> resultsList, Context context) {
        this.resultsList = resultsList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_music_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MusicPojo.Results result = resultsList.get(position);
        holder.tvArtistName.setText(result.getArtistName());
        holder.tvTrackName.setText(result.getTrackName());
        holder.tvGenreName.setText(result.getPrimaryGenreName());
        holder.tvDuration.setText(String.valueOf(result.getTrackTimeMillis()));
        holder.tvTrackPrice.setText(String.valueOf(result.getTrackPrice()));

        if ((result.getArtworkUrl100() != null) && (result.getArtworkUrl100().length() > 0)) {
            Uri uri = Uri.parse(result.getArtworkUrl100());

            Glide.with(context)
                    .load(uri)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imgArtwork);

        } else if ((result.getArtworkUrl100() == null) || (result.getArtworkUrl100().length() == 0)) {
            Glide.with(context)
                    .load(R.drawable.music).
                    diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imgArtwork);
        }

    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTrackName;
        TextView tvArtistName;
        TextView tvGenreName;
        TextView tvDuration;
        TextView tvTrackPrice;
        CircleImageView imgArtwork;
        LinearLayout llMusic;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTrackName = (TextView) itemView.findViewById(R.id.tvTrackName);
            tvArtistName = (TextView) itemView.findViewById(R.id.tvArtistName);
            tvGenreName = (TextView) itemView.findViewById(R.id.tvGenreName);
            tvDuration = (TextView) itemView.findViewById(R.id.tvDuration);
            tvTrackPrice = (TextView) itemView.findViewById(R.id.tvTrackPrice);
            imgArtwork = (CircleImageView) itemView.findViewById(R.id.imgArtwork);
            llMusic = (LinearLayout) itemView.findViewById(R.id.llMusic);
            llMusic.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.llMusic) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("result", resultsList.get(getAdapterPosition()));
                context.startActivity(intent);
            }
        }
    }
}
