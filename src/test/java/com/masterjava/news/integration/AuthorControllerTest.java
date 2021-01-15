package com.masterjava.news.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterjava.news.controllers.AuthorController;
import com.masterjava.news.models.Author;
import com.masterjava.news.services.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AuthorController.class)
public class AuthorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService authorService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addNewAuthor() throws Exception{
        //arrange
        Author author = new Author("John1", "Doe12", "This is a test description");
        when(authorService.addAuthor(any())).thenReturn(Arrays.asList(author));

        //act + assert
        mockMvc.perform(
                post("/authors/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(author))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$[*].lastName").value(author.getLastName()));
    }
}
