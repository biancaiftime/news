package com.masterjava.news.unit;


import com.masterjava.news.models.Topic;
import com.masterjava.news.repositories.TopicRepository;
import com.masterjava.news.services.TopicService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TopicTest {

    @InjectMocks
    private TopicService topicService;

    @Mock
    private TopicRepository topicRepository;

    @Test
    @DisplayName("Retrieve all topics")
    public void getAllTopicsTest(){
        //arrange
        when(topicRepository.getAllTopics()).thenReturn(
                Arrays.asList(new Topic(1, "Test Topic"))
        );

        //act
        List<Topic> result = topicRepository.getAllTopics();

        //assert
        Topic t = result.get(0);
        assertEquals(result.size(), 1);
        assertEquals(t.getName(), "Test Topic");
    }

    @Test
    @DisplayName("Retrieving a topic by name from repo")
    public void getTopicByNameTest(){
        //arrange
        String name = "modern mobile architecture";
        when(topicRepository.getAllTopics()).thenReturn(
                Arrays.asList(
                        new Topic(1, "Test Topic 1"),
                        new Topic(2, "Test Topic 2"),
                        new Topic(3, "modern mobile architecture"),
                        new Topic(4, "modern web architecture")
                )
        );

        //act
        var result = topicService.getAllTopics().stream().filter(t -> t.getName() == name);

        //assert
        assertTrue(result != null);
    }

    @Test
    @DisplayName("Adding a new topic to my repo")
    public void addTopicTest() {
        //arrange
        Topic topic = new Topic(1, "Test Topic");
        var topics = new ArrayList<Topic>(); topics.add(topic);
        when(topicRepository.addTopic(topic)).thenReturn(topics);

        //act
        var result = topicService.addTopic(topic).stream().filter(r -> r.getId() == topic.getId()).findFirst().get();

        //assert
        assertEquals(topic.getId(), result.getId());
        assertEquals(topic.getName(), result.getName());

        verify(topicRepository, times(1)).addTopic(topic);
    }
}
