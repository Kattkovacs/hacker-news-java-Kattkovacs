package com.codecool.hackernews.modal;

public class ResponseNewsModal {

    private String title;
    private String time_ago;
    private String author;
    private String url;

    public ResponseNewsModal(NewsModal newsModal){
        this.title = newsModal.getTitle();
        this.time_ago = newsModal.getTimeAgo();
        this.author = newsModal.getAuthor();
        this.url = newsModal.getUrl();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime_ago() {
        return time_ago;
    }

    public void setTime_ago(String time_ago) {
        this.time_ago = time_ago;
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
