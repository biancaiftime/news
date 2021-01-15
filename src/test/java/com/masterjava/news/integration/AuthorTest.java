package com.masterjava.news.integration;

import com.masterjava.news.models.Author;
import com.masterjava.news.services.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class AuthorTest {

    @Autowired
    private AuthorService authorService;

    @BeforeEach
    public void tearDown(){
        authorService.deleteAll();
    }

    @Test
    public void addAuthorHappyFlow(){
        Author author = new Author("John", "Doe", "This is a test description");

        var authors = authorService.addAuthor(author);
        var result = authors.stream().filter(a -> a.getFirstName().equals(author.getFirstName()) && a.getLastName().equals(author.getLastName()) && a.getBio().equals(author.getBio())).findFirst().get();

        assertNotNull(result.getId());
        assertEquals(author.getLastName(), result.getLastName());
        assertEquals(author.getFirstName(), result.getFirstName());
    }
}
