package com.masterjava.news.repositories;


import com.masterjava.news.dto.CommentDTO;
import com.masterjava.news.helpers.queries.ArticleQueries;
import com.masterjava.news.helpers.queries.CommentQueries;
import com.masterjava.news.helpers.rowmappers.ArticleRowMapper;
import com.masterjava.news.models.Article;
import com.masterjava.news.models.Comment;
import com.masterjava.news.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Comment> getAllComments()
    {
        var comments = jdbcTemplate.query(CommentQueries.getAllComments, new BeanPropertyRowMapper<>(Comment.class));
        comments.forEach(c -> c.setArticle(getArticleById(c.getArticleId())));
        return comments;
    }

    public List<Comment> getCommentsByArticleId(int id)
    {
        var comments = jdbcTemplate.query(CommentQueries.getCommentsByArticleId, new Object[]{id}, new BeanPropertyRowMapper<>(Comment.class));
        comments.forEach(c -> c.setArticle(getArticleById(id)));
        return comments;
    }

    public List<Comment> getCommentsByPersonName(String name)
    {
        var comments = jdbcTemplate.query(CommentQueries.getCommentsByPersonName, new Object[]{name}, new BeanPropertyRowMapper<>(Comment.class));
        comments.forEach(c -> c.setArticle(getArticleById(c.getArticleId())));
        return comments;
    }

    public List<Comment> addComment(CommentDTO commentDTO)
    {
        jdbcTemplate.update(CommentQueries.addComment, commentDTO.getPersonName(), commentDTO.getText(), commentDTO.getArticleId(), new Date());
        return getAllComments();
    }

    public List<Comment> deleteComment(int id)
    {
        jdbcTemplate.update(CommentQueries.deleteComment, id);
        return getAllComments();
    }

    private Article getArticleById(int id)
    {
        var article = jdbcTemplate.query(ArticleQueries.getArticleById, new Object[]{id}, new ArticleRowMapper()).stream().findFirst().get();
        article.setTopics(new ArrayList<Topic>(jdbcTemplate.query(ArticleQueries.getTopicsForArticle,
                new Object[]{article.getId()},
                new BeanPropertyRowMapper(Topic.class))));
        return article;
    }
}
