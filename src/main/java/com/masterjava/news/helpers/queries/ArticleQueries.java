package com.masterjava.news.helpers.queries;

public class ArticleQueries {

    public static final String getAllArticles = "SELECT ar.id, ar.title, ar.content, ar.category, ar.date, ar.authorId, au.firstName, au.lastName, au.bio FROM dbo.Articles ar JOIN dbo.Authors au ON ar.authorId = au.id";
    public static final String getArticleByName = "SELECT ar.id, ar.title, ar.content, ar.category, ar.date, ar.authorId, au.firstName, au.lastName, au.bio FROM dbo.Articles ar JOIN dbo.Authors au ON ar.authorId = au.id WHERE ar.title = ?";
    public static final String getArticlesByAuthorId = "SELECT ar.id, ar.title, ar.content, ar.category, ar.date, ar.authorId, au.firstName, au.lastName, au.bio FROM dbo.Articles ar JOIN dbo.Authors au ON ar.authorId = au.id WHERE ar.authorId = ?";
    public static final String getArticleById = "SELECT ar.id, ar.title, ar.content, ar.category, ar.date, ar.authorId, au.firstName, au.lastName, au.bio FROM dbo.Articles ar JOIN dbo.Authors au ON ar.authorId = au.id WHERE ar.id = ?";

    public static final String getTopicsForArticle = "SELECT t.id, t.name FROM dbo.Topics t JOIN dbo.Relations r ON t.id = r.topicId WHERE r.articleId = ?";
    public static final String getArticlesForTopic = "SELECT * FROM dbo.Relations r WHERE r.topicId = ?";

    public static final String addArticle = "INSERT INTO dbo.Articles(title,content,category,date,authorId) VALUES (?,?,?,?,?)";

    public static final String addRelation = "INSERT INTO dbo.Relations(articleId,topicId) VALUES(?,?)";

    public static final String deleteArticle = "DELETE FROM dbo.Articles WHERE id = ?";

    public static final String deleteAll = "DELETE FROM dbo.Articles";
}
