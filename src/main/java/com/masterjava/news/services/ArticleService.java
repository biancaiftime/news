package com.masterjava.news.services;


import com.masterjava.news.dto.ArticleDTO;
import com.masterjava.news.models.*;
import com.masterjava.news.repositories.ArticleRepository;
import com.masterjava.news.repositories.AuditRepository;
import com.masterjava.news.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TopicRepository topicRepository;


    public List<Article> getAllArticles()
    {
        return articleRepository.getAllArticles();
    }

    public Article getArticleByTitle(String title)
    {
        title = title.trim();
        return articleRepository.getArticleByTitle(title);
    }

    public List<Article> getArticlesByAuthorId(int authorId)
    {
        return articleRepository.getArticlesByAuthorId(authorId);
    }

    public List<Article> getArticlesByTopicName(String name)
    {
        name = name.trim();
        var topic = topicRepository.getTopicByName(name);
        return articleRepository.getArticlesByTopicId(topic.getId());
    }

    public List<Article> addArticle(ArticleDTO articleDTO)
    {
        return articleRepository.addArticle(articleDTO);
    }

    public List<Article> deleteArticle(int articleId)
    {
        return articleRepository.deleteArticle(articleId);
    }

    public void deleteAll(){articleRepository.deleteAll();}
}
