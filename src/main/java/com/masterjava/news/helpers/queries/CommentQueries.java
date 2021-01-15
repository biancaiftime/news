package com.masterjava.news.helpers.queries;

public class CommentQueries {
    public static final String addComment = "INSERT INTO dbo.Comments(personName,text,articleId,date) VALUES(?,?,?,?)";
    public static final String getAllComments = "SELECT * FROM dbo.Comments";
    public static final String getCommentsByArticleId = "SELECT * FROM dbo.Comments WHERE articleId = ?";
    public static final String getCommentsByPersonName = "SELECT * FROM dbo.Comments WHERE personName = ?";
    public static final String deleteComment = "DELETE FROM dbo.Comments WHERE id = ?";
    public static final String deleteAll = "DELETE FROM dbo.Comments";
}
