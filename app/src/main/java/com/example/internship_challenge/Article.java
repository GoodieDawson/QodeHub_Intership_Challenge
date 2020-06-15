package com.example.internship_challenge;

import java.io.Serializable;

public class Article implements Serializable {
    public String article_name;
    public String article_publisher;
    public String article_img;
    public String article_text;

    public Article(String article_name, String article_publisher, String article_img, String article_text) {
        this.article_name = article_name;
        this.article_publisher = article_publisher;
        this.article_img = article_img;
        this.article_text = article_text;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public String getArticle_publisher() {
        return article_publisher;
    }

    public void setArticle_publisher(String article_publisher) {
        this.article_publisher = article_publisher;
    }

    public String getArticle_img() {
        return article_img;
    }

    public void setArticle_img(String article_img) {
        this.article_img = article_img;
    }

    public String getArticle_text() {
        return article_text;
    }

    public void setArticle_text(String article_text) {
        this.article_text = article_text;
    }
}
