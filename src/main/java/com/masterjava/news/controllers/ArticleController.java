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

    @GetMapping("/byAuthorId")
    public ResponseEntity<?> getArticlesByAuthorId(@RequestParam int authorId){return ResponseEntity.ok().body(articleService.getArticlesByAuthorId(authorId));}


    @PostMapping("/add")
    public ResponseEntity<?> addArticle(@RequestBody ArticleDTO articleDTO) {return ResponseEntity.ok().body(articleService.addArticle(articleDTO));}

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteArticle(@RequestParam int id) {return ResponseEntity.ok().body(articleService.deleteArticle(id));}

}
