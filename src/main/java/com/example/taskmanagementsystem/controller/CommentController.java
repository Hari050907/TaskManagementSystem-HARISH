package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.exception.BadRequestException;
import com.example.taskmanagementsystem.exception.ResourceNotFoundException;
import com.example.taskmanagementsystem.model.Comment;
import com.example.taskmanagementsystem.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getComment(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        if (comment == null) {
            throw new ResourceNotFoundException("Comment not found with id " + id);
        }
        return ResponseEntity.ok(comment);
    }

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        Comment saved = commentService.addComment(comment);
        if (saved == null) {
            throw new BadRequestException("Unable to add comment");
        }
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
