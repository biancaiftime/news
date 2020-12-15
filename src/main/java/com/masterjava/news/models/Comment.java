package com.masterjava.news.models;

import java.util.Date;

public class Comment {

    private int id;
    private String personName;
    private String content;
    private Article article;
    private Date date;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Comment(int id, String personName, String content, Article article, Date date) {
        this.id = id;
        this.personName = personName;
        this.content = content;
        this.article = article;
        this.date = date;
    }

    public Comment() {
    }
}
