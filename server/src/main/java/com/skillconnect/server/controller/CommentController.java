package com.skillconnect.server.controller;

import com.skillconnect.server.model.Comment;
import com.skillconnect.server.model.User;
import com.skillconnect.server.service.CommentService;
<<<<<<< HEAD
<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
=======
import lombok.AllArgsConstructor;
>>>>>>> origin/Member02
=======
import lombok.AllArgsConstructor;
>>>>>>> origin/Member04
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
<<<<<<< HEAD
<<<<<<< HEAD
=======
@AllArgsConstructor(onConstructor = @__(@Autowired))
>>>>>>> origin/Member02
=======
@AllArgsConstructor(onConstructor = @__(@Autowired))
>>>>>>> origin/Member04
public class CommentController {

    private final CommentService commentService;

<<<<<<< HEAD
<<<<<<< HEAD
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment created = commentService.createComment(comment);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable int id) {
        return commentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable int postId) {
        return ResponseEntity.ok(commentService.findCommentsByPostId(postId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Comment>> getCommentsByUserId(@PathVariable int userId) {
<<<<<<< HEAD
<<<<<<< HEAD
        return ResponseEntity.ok(commentService.findCommentsByUserId(userId));
=======
        User user = new User();
        user.setUserId(userId);
        return ResponseEntity.ok(commentService.findCommentsByUserId(user));
>>>>>>> origin/Member02
=======
        User user = new User();
        user.setUserId(userId);
        return ResponseEntity.ok(commentService.findCommentsByUserId(user));
>>>>>>> origin/Member04
    }

    @PutMapping
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.updateComment(comment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}

