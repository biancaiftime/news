package com.masterjava.news.controllers;

import com.masterjava.news.models.Author;
import com.masterjava.news.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public ResponseEntity<?> getAllAuthors() {return ResponseEntity.ok().body(authorService.getAllAuthors());}

    @GetMapping("/byName")
    public ResponseEntity<?> getAuthorByName(@RequestParam String name) {return ResponseEntity.ok().body(authorService.getAuthorByName(name));}

    @PostMapping("/add")
    public ResponseEntity<?> addAuthor(@RequestBody @Valid Author author)
    {
        return ResponseEntity.ok().body(authorService.addAuthor(author));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAuthor(@RequestParam int id) {return ResponseEntity.ok().body(authorService.deleteAuthor(id));}
}
