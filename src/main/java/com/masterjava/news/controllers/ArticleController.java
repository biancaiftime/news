package com.masterjava.news.controllers;

import com.masterjava.news.models.Article;
import com.masterjava.news.models.Author;
import com.masterjava.news.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping()
    public List<Article> getAllArticles()
    {
        return null;
    }

    @GetMapping("/byAuthor")
    public ResponseEntity<?> getArticlesByAuthor(@RequestParam String authorName)
    {
        return null;
    }


}
