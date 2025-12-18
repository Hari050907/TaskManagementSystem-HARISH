package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.model.Comment;

public interface CommentService {

    Comment addComment(Comment comment);
    String getCommentById(Long id);
}
