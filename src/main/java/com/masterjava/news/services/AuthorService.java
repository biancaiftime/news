package com.masterjava.news.services;


import com.masterjava.news.models.Author;
import com.masterjava.news.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> getAllAuthors()
    {
        return authorRepository.getAllAuthors();
    }

    public Author getAuthorByName(String name)
    {
        name = name.trim();
        return authorRepository.getAuthorByName(name);
    }

    public List<Author> addAuthor(Author author)
    {
        return authorRepository.addAuthor(author);
    }

    public List<Author> deleteAuthor(int id)
    {
        return authorRepository.deleteAuthor(id);
    }

    public void deleteAll(){authorRepository.deleteAll();}
}
