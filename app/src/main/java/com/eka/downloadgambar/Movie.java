package com.eka.downloadgambar;

public class Movie {
    private int id;
    private String title;
    private String overview;
    private String image;
    private float vote;

    public Movie(int id, String title, String overview, String image, float vote) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.image = image;
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getVote() {
        return vote;
    }

    public void setVote(float vote) {
        this.vote = vote;
    }
}
