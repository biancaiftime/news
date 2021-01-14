package com.masterjava.news.services;


import com.masterjava.news.models.*;
import com.masterjava.news.repositories.AuditRepository;
import com.masterjava.news.repositories.AuthorRepository;
import com.masterjava.news.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;


    public List<Topic> getAllTopics()
    {
        return topicRepository.getAllTopics();
    }

    public Topic getTopicByName(String name)
    {
        return topicRepository.getTopicByName(name);
    }

    public List<Topic> addTopic(Topic topic)
    {
        return topicRepository.addTopic(topic);
    }

    public List<Topic> deleteTopic(int id)
    {
        return topicRepository.deleteTopic(id);
    }
}
