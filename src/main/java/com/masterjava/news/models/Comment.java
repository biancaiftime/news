package com.masterjava.news.models;

import java.util.Date;

public class Comment {

    private int id;
    private String personName;
    private String text;
    private Article article;
    private Date date;
    private int articleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Comment(int id, String personName, String text, Article article, Date date, int articleId) {
        this.id = id;
        this.personName = personName;
        this.text = text;
        this.article = article;
        this.date = date;
        this.articleId = articleId;
    }

    public Comment() {
    }
}
