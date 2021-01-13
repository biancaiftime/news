package com.masterjava.news.repositories;


import com.masterjava.news.dto.ArticleDTO;
import com.masterjava.news.helpers.queries.ArticleQueries;
import com.masterjava.news.models.Article;
import com.masterjava.news.models.Author;
import com.masterjava.news.models.Category;
import com.masterjava.news.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Article> getAllArticles()
    {
        var articles = jdbcTemplate.query(ArticleQueries.getAllArticles, new ArticleRowMapper());
        articles.forEach(article -> article.setTopics(new ArrayList<Topic>(jdbcTemplate.query(ArticleQueries.getTopicsForArticle,
                                                      new Object[]{article.getId()},
                                                      new BeanPropertyRowMapper(Topic.class)))));
        return articles;
    }

    public List<Article> addArticle(ArticleDTO articleDTO)
    {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ArticleQueries.addArticle, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,articleDTO.getTitle());
            ps.setString(2, articleDTO.getContent());
            ps.setString(3,articleDTO.getCategory().name());
            ps.setDate(4, new java.sql.Date(new Date().getTime()));
            ps.setInt(5, articleDTO.getAuthorId());
            return ps;
        }, keyHolder);
        var articleId =keyHolder.getKey().intValue();
        articleDTO.getTopicsIDs().forEach(t -> jdbcTemplate.update(ArticleQueries.addRelation, articleId, t));
        return getAllArticles();
    }

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
}
