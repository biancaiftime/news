package com.masterjava.news.models;

import org.springframework.lang.NonNull;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

public class Article {

    private int id;
    @NotEmpty
    @Size(max = 30)
    private String title;
    @NotEmpty
    @Size(min = 50)
    private String content;
    @NotEmpty
    private Author author;
    private ArrayList<Topic> topics;
    @NotEmpty
    private Category category;

    private Date date;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Article(int id, String title, String content, Author author, ArrayList<Topic> topics, Category category, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.topics = topics;
        this.category = category;
        this.date = date;
    }

    public Article() {
    }
}
