package com.masterjava.news.repositories;


import com.masterjava.news.dto.ArticleDTO;
import com.masterjava.news.helpers.queries.ArticleQueries;
import com.masterjava.news.helpers.rowmappers.ArticleRowMapper;
import com.masterjava.news.models.*;
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
import java.util.stream.Collectors;

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

    public Article getArticleByTitle(String title)
    {
        var article = jdbcTemplate.query(ArticleQueries.getArticleByName, new Object[]{title}, new ArticleRowMapper()).stream().findFirst().get();
        article.setTopics(new ArrayList<Topic>(jdbcTemplate.query(ArticleQueries.getTopicsForArticle,
                new Object[]{article.getId()},
                new BeanPropertyRowMapper(Topic.class))));
        return article;
    }

    public List<Article> getArticlesByAuthorId(int authorId)
    {
        var articles = jdbcTemplate.query(ArticleQueries.getArticlesByAuthorId, new Object[]{authorId}, new ArticleRowMapper());
        articles.forEach(article -> article.setTopics(new ArrayList<Topic>(jdbcTemplate.query(ArticleQueries.getTopicsForArticle,
                new Object[]{article.getId()},
                new BeanPropertyRowMapper(Topic.class)))));
        return articles;
    }

    public List<Article> getArticlesByTopicId(int topicId)
    {
        var relations = jdbcTemplate.query(ArticleQueries.getArticlesForTopic, new Object[]{topicId}, new BeanPropertyRowMapper<>(Relation.class));
        var articles = new ArrayList<Article>();
        relations.forEach(r -> {
            var article = jdbcTemplate.query(ArticleQueries.getArticleById, new Object[]{r.getArticleId()}, new ArticleRowMapper()).stream().findFirst().get();
            article.setTopics(new ArrayList<Topic>(jdbcTemplate.query(ArticleQueries.getTopicsForArticle,
                    new Object[]{article.getId()},
                    new BeanPropertyRowMapper(Topic.class))));
            articles.add(article);
        });
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

    public List<Article> deleteArticle(int articleId)
    {
        jdbcTemplate.update(ArticleQueries.deleteArticle, articleId);
        return getAllArticles();
    }

    public void deleteAll() {jdbcTemplate.update(ArticleQueries.deleteAll);}

}
