package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.model.Comment;
import com.example.taskmanagementsystem.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<String> getComment(@PathVariable Long id){
       String comment = commentServiceImpl.getCommentById(id);
       if(comment != null){
           return new ResponseEntity<>(comment, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        Comment comment1 = commentServiceImpl.addComment(comment);
        if(comment1 != null){
            return new ResponseEntity<>(comment1,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
