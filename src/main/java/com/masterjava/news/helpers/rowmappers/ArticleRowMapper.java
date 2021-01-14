package com.masterjava.news.helpers.rowmappers;

import com.masterjava.news.models.Article;
import com.masterjava.news.models.Author;
import com.masterjava.news.models.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet resultSet, int i) throws SQLException {
        var article =  new Article(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("content"),
                Category.valueOf(resultSet.getString("category")),
                resultSet.getDate("date"));
        var author = new Author(
                resultSet.getInt("authorId"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("bio"));
        article.setAuthor(author);
        return article;
    }
}
