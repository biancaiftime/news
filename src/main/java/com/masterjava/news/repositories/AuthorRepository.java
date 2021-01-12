package com.masterjava.news.repositories;

import com.masterjava.news.helpers.queries.AuthorQueries;
import com.masterjava.news.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Author> getAllAuthors() {return jdbcTemplate.query(AuthorQueries.getAuthors, new BeanPropertyRowMapper<>(Author.class));}

    public Author getAuthorByName(String name) {return jdbcTemplate.query(AuthorQueries.getAuthorByName, new Object[]{name},new BeanPropertyRowMapper<>(Author.class)).stream().findFirst().get();}

    public List<Author> addAuthor(Author author)
    {
        jdbcTemplate.update(AuthorQueries.addAuthor, author.getFirstName(), author.getLastName(), author.getBio());
        return jdbcTemplate.query(AuthorQueries.getAuthors, new BeanPropertyRowMapper<>(Author.class));
    }
}
