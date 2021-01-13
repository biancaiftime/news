package com.masterjava.news.services;


import com.masterjava.news.models.Audit;
import com.masterjava.news.models.Author;
import com.masterjava.news.models.ObjectType;
import com.masterjava.news.models.Operation;
import com.masterjava.news.repositories.AuditRepository;
import com.masterjava.news.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuditRepository auditRepository;


    public List<Author> getAllAuthors()
    {
        var authors =  authorRepository.getAllAuthors();
        auditRepository.addRecord(new Audit(Operation.GET, ObjectType.Author, "getAllAuthors() method invoked",new Date()));
        return authors;
    }

    public Author getAuthorByName(String name)
    {
        var authors =  authorRepository.getAuthorByName(name);
        auditRepository.addRecord(new Audit(Operation.GET, ObjectType.Author, "getAuthorByName() method invoked",new Date()));
        return authors;
    }

    public List<Author> addAuthor(Author author)
    {
        var authors = authorRepository.addAuthor(author);
        auditRepository.addRecord(new Audit(Operation.ADD, ObjectType.Author, "addAuthor() method invoked",new Date()));
        return authors;
    }

    public List<Author> deleteAuthor(int id)
    {
        var authors = authorRepository.deleteAuthor(id);
        auditRepository.addRecord(new Audit(Operation.DELETE, ObjectType.Author, "deleteAuthor() method invoked",new Date()));
        return authors;
    }
}
