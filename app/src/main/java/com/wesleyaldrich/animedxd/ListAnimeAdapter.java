package com.wesleyaldrich.animedxd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAnimeAdapter extends RecyclerView.Adapter<ListAnimeAdapter.AnimeViewHolder> {
    private List<AnimeList> animeList;
    private OnItemClickListener listener;

    // Interface untuk click listener
    public interface OnItemClickListener {
        void onItemClick(AnimeList anime);
    }

    public ListAnimeAdapter(List<AnimeList> animeList, OnItemClickListener listener) {
        this.animeList = animeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anime_list, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        AnimeList anime = animeList.get(position);
        holder.bind(anime, listener);
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        ImageView animeImageView;
        TextView animeTitleTextView;
        TextView animeDescriptionTextView;
        TextView animeGenreTextView;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            animeImageView = itemView.findViewById(R.id.animeImageView);
            animeTitleTextView = itemView.findViewById(R.id.animeTitleTextView);
            animeDescriptionTextView = itemView.findViewById(R.id.animeDescriptionTextView);
            animeGenreTextView = itemView.findViewById(R.id.animeGenreTextView);
        }
        public void bind(final AnimeList anime, final OnItemClickListener listener) {
            animeImageView.setImageResource(anime.getImageUrl());
            animeTitleTextView.setText(anime.getTitle());
            animeDescriptionTextView.setText(anime.getSynopsis());
            animeGenreTextView.setText(anime.getGenre());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(anime);
                }
            });
        }
    }
}