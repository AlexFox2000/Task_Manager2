package com.task.mc_comment.controller;

import com.task.mc_comment.entity.Comment;
import com.task.mc_comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Comment createdNewComment (@RequestBody Comment comment){
        return commentService.createdNewComment(comment);
    }

    @GetMapping ("/{id}")
    public Comment getCommentByTaskId (@PathVariable Long taskId){
        return commentService.getCommentByTaskId(taskId);
    }

    @DeleteMapping
    public void deleteComment (@PathVariable Long id){
        commentService.deleteComment(id);
    }

}
