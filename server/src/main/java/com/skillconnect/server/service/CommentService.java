package com.skillconnect.server.service;

import com.skillconnect.server.model.Comment;
import com.skillconnect.server.model.User;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    
    Comment createComment(Comment comment);
    
    Optional<Comment> findById(int commentId);
    
    List<Comment> findCommentsByPostId(int postId);
    
<<<<<<< HEAD
    List<Comment> findCommentsByUserId(int id);
=======
    List<Comment> findCommentsByUserId(User user);
>>>>>>> origin/Member02
    
    Comment updateComment(Comment comment);
    
    void deleteComment(int commentId);
}
