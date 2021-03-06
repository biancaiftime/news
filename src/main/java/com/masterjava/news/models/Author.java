package com.masterjava.news.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Author {

    private int id;
    @Size(min = 5, max = 20)
    @NotNull
    private String firstName;
    @Size(min = 5, max = 20)
    @NotNull
    private String lastName;
    @NotNull
    @Size(min = 5)
    private String bio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Author(int id, String firstName, String lastName, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

    public Author() {
    }

    public Author(@Size(min = 5, max = 20) @NotNull String firstName, @Size(min = 5, max = 20) @NotNull String lastName, @NotNull @Size(min = 5) String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }
}
