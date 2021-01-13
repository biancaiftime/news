package com.masterjava.news.dto;

import com.masterjava.news.models.Author;
import com.masterjava.news.models.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

public class ArticleDTO {
    private int id;
    @NotEmpty
    @Size(max = 30)
    private String title;
    @NotEmpty
    @Size(min = 50)
    private String content;
    @NotEmpty
    private int authorId;
    private ArrayList<Integer> topicsIDs;
    @NotEmpty
    private Category category;


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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public ArrayList<Integer> getTopicsIDs() {
        return topicsIDs;
    }

    public void setTopicsIDs(ArrayList<Integer> topicsIDs) {
        this.topicsIDs = topicsIDs;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public ArticleDTO(int id, String title, String content, int authorId, ArrayList<Integer> topicsIDs, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.topicsIDs = topicsIDs;
        this.category = category;
    }

    public ArticleDTO() {
    }
}
