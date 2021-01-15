package com.masterjava.news.controllers;

import com.masterjava.news.models.Author;
import com.masterjava.news.models.Topic;
import com.masterjava.news.services.AuthorService;
import com.masterjava.news.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping()
    public ResponseEntity<?> getAllTopics() {return ResponseEntity.ok().body(topicService.getAllTopics());}

    @GetMapping("/byName")
    public ResponseEntity<?> getTopicByName(@RequestParam String name) {return ResponseEntity.ok().body(topicService.getTopicByName(name));}

    @PostMapping("/add")
    public ResponseEntity<?> addTopic(@RequestBody @Valid Topic topic)
    {
        return ResponseEntity.ok().body(topicService.addTopic(topic));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTopic(@RequestParam int id) {return ResponseEntity.ok().body(topicService.deleteTopic(id));}

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {topicService.deleteAll(); return ResponseEntity.ok("Deleted all topics");}
}
