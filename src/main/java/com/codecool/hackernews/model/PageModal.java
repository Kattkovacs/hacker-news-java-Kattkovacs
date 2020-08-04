package com.codecool.hackernews.modal;

import java.util.ArrayList;
import java.util.List;

public class PageModal {

    List<NewsModal> news = new ArrayList<>();

    public List<NewsModal> getNews() {
        return news;
    }

    public void setNews(List<NewsModal> news) {
        this.news = news;
    }

    public void addNews(NewsModal newsModal) {
        this.news.add(newsModal);
    }
}
