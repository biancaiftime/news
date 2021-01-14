package com.masterjava.news.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masterjava.news.models.Article;

import java.util.Date;

public class CommentDTO {

    private int id;
    private String personName;
    private String text;
    private int articleId;
    @JsonIgnore
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

    public String getText() {
        return text;
    }

    public void setText(String content) {
        this.text = content;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CommentDTO(int id, String personName, String text, int articleId) {
        this.id = id;
        this.personName = personName;
        this.text = text;
        this.articleId = articleId;
        this.date = new Date();
    }

    public CommentDTO() {
    }
}
