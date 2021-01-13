package com.masterjava.news.services;


import com.masterjava.news.dto.ArticleDTO;
import com.masterjava.news.models.*;
import com.masterjava.news.repositories.ArticleRepository;
import com.masterjava.news.repositories.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private AuditRepository auditRepository;


    public List<Article> getAllArticles()
    {
        var articles =  articleRepository.getAllArticles();
        auditRepository.addRecord(new Audit(Operation.GET, ObjectType.Article, "getAllArticles() method invoked",new Date()));
        return articles;
    }

    public List<Article> addArticle(ArticleDTO articleDTO)
    {
        var articles =  articleRepository.addArticle(articleDTO);
        auditRepository.addRecord(new Audit(Operation.ADD, ObjectType.Article, "addArticle() method invoked",new Date()));
        return articles;
    }
}
