package com.example.mediabase.podcastui;

public class PodcastUI {

    private static final long serialVersionUID = 1L;

    public PodcastUI(){};

    public PodcastUI(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String title;
    private String description;
    private String url;



}
