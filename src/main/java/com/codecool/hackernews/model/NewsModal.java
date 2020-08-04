package com.codecool.hackernews.modal;

import com.google.gson.JsonElement;

public class NewsModal {
    private int id;
    private int points;
    private String title;
    private String timeAgo;
    private String author;
    private String url;
    private String type;
    private String domain;

    public NewsModal(JsonElement id, JsonElement points, JsonElement title, JsonElement timeAgo, JsonElement author, JsonElement url, JsonElement type, JsonElement domain) {
        this.id = Integer.parseInt(String.valueOf(id));
        this.points = Integer.parseInt(String.valueOf(points));
        this.title = String.valueOf(title);
        this.timeAgo = String.valueOf(timeAgo);
        this.author = String.valueOf(author);
        this.url = String.valueOf(url);
        this.type = String.valueOf(type);
        this.domain = String.valueOf(domain);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}