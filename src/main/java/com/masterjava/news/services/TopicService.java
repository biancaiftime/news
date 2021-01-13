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

    @Autowired
    private AuditRepository auditRepository;


    public List<Topic> getAllTopics()
    {
        var topics =  topicRepository.getAllTopics();
        auditRepository.addRecord(new Audit(Operation.GET, ObjectType.Topic, "getAllTopics() method invoked",new Date()));
        return topics;
    }

    public Topic getTopicByName(String name)
    {
        var topics =  topicRepository.getTopicByName(name);
        auditRepository.addRecord(new Audit(Operation.GET, ObjectType.Topic, "getTopicByName() method invoked",new Date()));
        return topics;
    }

    public List<Topic> addTopic(Topic topic)
    {
        var topics = topicRepository.addTopic(topic);
        auditRepository.addRecord(new Audit(Operation.ADD, ObjectType.Topic, "addTopic() method invoked",new Date()));
        return topics;
    }

    public List<Topic> deleteTopic(int id)
    {
        var topics = topicRepository.deleteTopic(id);
        auditRepository.addRecord(new Audit(Operation.DELETE, ObjectType.Topic, "deleteTopic() method invoked",new Date()));
        return topics;
    }
}
