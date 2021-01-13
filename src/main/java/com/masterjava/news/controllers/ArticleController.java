package com.masterjava.news.controllers;

import com.masterjava.news.dto.ArticleDTO;
import com.masterjava.news.models.Article;
import com.masterjava.news.models.Author;
import com.masterjava.news.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping()
    public ResponseEntity<?> getAllArticles(){return ResponseEntity.ok().body(articleService.getAllArticles());}

    @GetMapping("/byTitle")
    public ResponseEntity<?> getArticleByName(@RequestParam String title){return ResponseEntity.ok().body(articleService.getArticleByTitle(title));}

    @GetMapping("/byAuthor")
    public ResponseEntity<?> getArticlesByAuthor(@RequestParam String authorName)
    {
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addArticle(@RequestBody ArticleDTO articleDTO) {return ResponseEntity.ok().body(articleService.addArticle(articleDTO));}


}
