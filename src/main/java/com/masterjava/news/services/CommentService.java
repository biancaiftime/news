package com.masterjava.news.services;


import com.masterjava.news.dto.CommentDTO;
import com.masterjava.news.models.Comment;
import com.masterjava.news.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments()
    {
        return commentRepository.getAllComments();
    }
    public List<Comment> getCommentsByArticleId(int id)
    {
        return commentRepository.getCommentsByArticleId(id);
    }
    public List<Comment> getCommentsByPersonName(String name)
    {
        return commentRepository.getCommentsByPersonName(name);
    }

    public List<Comment> addComment(CommentDTO commentDTO)
    {
        return commentRepository.addComment(commentDTO);
    }

    public List<Comment> deleteComment(int id)
    {
        return commentRepository.deleteComment(id);
    }

}
