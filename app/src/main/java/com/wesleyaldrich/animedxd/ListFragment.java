package com.wesleyaldrich.animedxd;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements ListAnimeAdapter.OnItemClickListener {

    private ListAnimeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView animeRecyclerView = view.findViewById(R.id.animeRecyclerView);
        animeRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<AnimeList> animeList = generateAnimeList();

        adapter = new ListAnimeAdapter(animeList, this);
        animeRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AnimeList anime) {
        Intent intent = new Intent(requireContext(), AnimeDetailActivity.class);

        intent.putExtra(AnimeDetailActivity.EXTRA_ANIME_TITLE, anime.getTitle());
        intent.putExtra(AnimeDetailActivity.EXTRA_ANIME_SYNOPSIS, anime.getSynopsis());
        intent.putExtra(AnimeDetailActivity.EXTRA_ANIME_GENRE, anime.getGenre());
        intent.putExtra(AnimeDetailActivity.EXTRA_ANIME_IMAGE, anime.getImageUrl());

        startActivity(intent);
    }

    private List<AnimeList> generateAnimeList() {
        List<AnimeList> list = new ArrayList<>();

        list.add(
                new AnimeList(
                        "Akudama Drive",
                        "A former convict becomes a rakugo performer, diving into the emotional stories and struggles of his mentor's past.",
                        "Action",
                        R.drawable.anime1
                )
        );
        list.add(
                new AnimeList(
                        "Shouwa Genroku Rakugo Shinjuu",
                        "A former convict becomes a rakugo performer, diving into the emotional stories and struggles of his mentor's past.",
                        "Drama",
                        R.drawable.anime2
                )
        );
        list.add(
                new AnimeList(
                        "Haven't You Heard? I'm Sakamoto",
                        "Sakamoto is the coolest and most perfect high school student ever – and everything he does is effortlessly stylish and absurdly funny.",
                        "Comedy",
                        R.drawable.anime3
                )
        );
        list.add(
                new AnimeList(
                        "Tsuki ga Kirei",
                        "A shy middle school boy and girl fall in love for the first time and navigate their feelings with awkwardness and sincerity.",
                        "Fantasy",
                        R.drawable.anime4
                )
        );
        list.add(
                new AnimeList(
                        "Shiki",
                        "In a quiet village, people begin dying mysteriously. A doctor and a teenager uncover a terrifying truth — the undead have arrived.",
                        "Mecha",
                        R.drawable.anime5
                )
        );
        list.add(
                new AnimeList(
                        "Kaiji: Ultimate Survivor",
                        "A down-on-his-luck man is dragged into underground gambling where he must use his wits to survive life-threatening games of deception.",
                        "Sci-Fi",
                        R.drawable.anime6
                )
        );
        list.add(
                new AnimeList(
                        "Silver Spoon (Gin no Saji)",
                        "A city boy enrolls in an agricultural school and experiences the challenges of farming life, hard work, and self-discovery.",
                        "Action",
                        R.drawable.anime7
                )
        );
        list.add(
                new AnimeList(
                        "Run with the Wind",
                        "A group of college students with little experience train together to run the famous Hakone Ekiden marathon.",
                        "Romance",
                        R.drawable.anime8
                )
        );
        list.add(
                new AnimeList(
                        "Mononoke",
                        "A mysterious medicine seller travels across Japan, exorcising malevolent spirits by uncovering their Form, Truth, and Reason.",
                        "Drama",
                        R.drawable.anime9
                )
        );

        return list;
    }
}