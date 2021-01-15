package com.masterjava.news.models;

public class Relation {

    private int id;
    private int articleId;
    private int topicId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public Relation() {
    }

    public Relation(int id, int articleId, int topicId) {
        this.id = id;
        this.articleId = articleId;
        this.topicId = topicId;
    }
}
