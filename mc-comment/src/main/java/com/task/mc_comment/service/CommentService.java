package com.task.mc_comment.service;

import com.task.mc_comment.entity.Comment;
import com.task.mc_comment.repository.CommentRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createdNewComment (Comment comment){
        return commentRepository.save(comment);
    }

    public Comment getCommentByTaskId (Long taskId) {
         return commentRepository.findById(taskId).orElseThrow(() ->
                new IllegalArgumentException("No comments for this task with id " + taskId));
    }

    public void deleteComment (Long id){
        commentRepository.deleteById(id);
    }
}
