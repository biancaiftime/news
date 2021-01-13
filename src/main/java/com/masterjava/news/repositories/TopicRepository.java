package com.masterjava.news.repositories;

import com.masterjava.news.helpers.queries.TopicQueries;
import com.masterjava.news.models.Author;
import com.masterjava.news.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Topic> getAllTopics() {return jdbcTemplate.query(TopicQueries.getTopics, new BeanPropertyRowMapper<>(Topic.class));}

    public Topic getTopicByName(String name) {return jdbcTemplate.query(TopicQueries.getByName, new Object[]{name},new BeanPropertyRowMapper<>(Topic.class)).stream().findFirst().get();}

    public Topic getTopicById(int id) {return jdbcTemplate.query(TopicQueries.getById, new Object[]{id},new BeanPropertyRowMapper<>(Topic.class)).stream().findFirst().get();}

    public List<Topic> addTopic(Topic topic)
    {
        jdbcTemplate.update(TopicQueries.addTopic, topic.getName());
        return jdbcTemplate.query(TopicQueries.getTopics, new BeanPropertyRowMapper<>(Topic.class));
    }

    public List<Topic> deleteTopic(int id)
    {
        jdbcTemplate.update(TopicQueries.delete, id);
        return jdbcTemplate.query(TopicQueries.getTopics, new BeanPropertyRowMapper<>(Topic.class));
    }
}
