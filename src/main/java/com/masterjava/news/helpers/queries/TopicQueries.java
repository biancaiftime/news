package com.masterjava.news.helpers.queries;

public class TopicQueries {
    public static final String getTopics = "SELECT * FROM dbo.Topics";
    public static final String addTopic = "INSERT INTO dbo.Topics(name) VALUES(?)";
    public static final String getByName = "SELECT * FROM dbo.Topics WHERE name = ?";
    public static final String getById = "SELECT * FROM dbo.Topics WHERE id = ?";
    public static final String delete = "DELETE FROM dbo.Topics WHERE id = ?";
    public static final String deleteAll = "DELETE FROM dbo.Topics";
}
