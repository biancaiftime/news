package com.masterjava.news.controllers;

import com.masterjava.news.dto.CommentDTO;
import com.masterjava.news.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping()
    public ResponseEntity<?> getAllComments() {return ResponseEntity.ok().body(commentService.getAllComments());}

    @GetMapping("/byArticleId")
    public ResponseEntity<?> getCommentsByArticleId(@RequestParam int id) {return ResponseEntity.ok().body(commentService.getCommentsByArticleId(id));}

    @GetMapping("/byPersonName")
    public ResponseEntity<?> getCommentsByPersonName(@RequestParam String name) {return ResponseEntity.ok().body(commentService.getCommentsByPersonName(name));}

    @PostMapping("/add")
    public ResponseEntity<?> addComment(@RequestBody @Valid CommentDTO commentDTO) {return ResponseEntity.ok().body(commentService.addComment(commentDTO));}

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteComment(@RequestParam int id) {return ResponseEntity.ok().body(commentService.deleteComment(id));}

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {commentService.deleteAll(); return ResponseEntity.ok("Deleted all comments");}
}
