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


    public List<Article> getAllArticles()
    {
        return articleRepository.getAllArticles();
    }

    public Article getArticleByTitle(String title)
    {
        return articleRepository.getArticleByTitle(title);
    }

    public List<Article> getArticlesByAuthorId(int authorId)
    {
        return articleRepository.getArticlesByAuthorId(authorId);
    }

    public List<Article> addArticle(ArticleDTO articleDTO)
    {
        return articleRepository.addArticle(articleDTO);
    }

    public List<Article> deleteArticle(int articleId)
    {
        return articleRepository.deleteArticle(articleId);
    }
}
