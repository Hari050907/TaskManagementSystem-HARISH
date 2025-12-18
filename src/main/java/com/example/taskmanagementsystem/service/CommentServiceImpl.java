package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.model.Comment;
import com.example.taskmanagementsystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public String getCommentById(Long id){
        return commentRepository.findById(id).map(Comment::getComment).orElse(null);
    }
    @Override
    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }


}
