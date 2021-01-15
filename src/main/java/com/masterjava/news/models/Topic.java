package com.masterjava.news.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Topic {

    private int id;
    @Size(min = 5, max = 40)
    @NotNull
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Topic(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Topic() {
    }
}
