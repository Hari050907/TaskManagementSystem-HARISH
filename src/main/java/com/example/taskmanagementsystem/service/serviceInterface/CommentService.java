package com.example.taskmanagementsystem.service.serviceInterface;

import com.example.taskmanagementsystem.model.Comment;

public interface CommentService {
    Comment addComment(Comment comment);
    Comment getCommentById(Long id);
}
