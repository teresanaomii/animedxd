package com.wesleyaldrich.animedxd;
public class AnimeList {
    private String title;
    private String synopis;
    private String genre;
    private int imageUrl;

    public AnimeList(String title, String description, String genre, int imageUrl) {
        this.title = title;
        this.synopis = description;
        this.genre = genre;
        this.imageUrl = imageUrl;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopis;
    }

    public String getGenre() {
        return genre;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}