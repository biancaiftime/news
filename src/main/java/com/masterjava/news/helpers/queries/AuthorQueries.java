package com.masterjava.news.helpers.queries;

public class AuthorQueries {

    public static final String getAuthors = "SELECT * FROM dbo.Authors";
    public static final String addAuthor = "INSERT INTO dbo.Authors(firstName,lastName,bio) VALUES (?,?,?)";
    public static final String getAuthorByName = "SELECT * FROM dbo.Authors WHERE firstName = ? ";
    public static final String deleteAuthor = "DELETE FROM dbo.Authors WHERE id = ?";
    public static final String getAuthorById = "SELECT * FROM dbo.Authors WHERE id = ?";
}
