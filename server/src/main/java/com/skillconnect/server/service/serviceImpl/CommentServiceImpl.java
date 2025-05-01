package com.skillconnect.server.service.serviceImpl;

import com.skillconnect.server.model.Comment;
<<<<<<< HEAD
import com.skillconnect.server.model.Notification;
=======
>>>>>>> origin/Member02
import com.skillconnect.server.model.Post;
import com.skillconnect.server.model.User;
import com.skillconnect.server.repository.CommentRepository;
import com.skillconnect.server.repository.PostRepository;
import com.skillconnect.server.repository.UserRepository;
import com.skillconnect.server.service.CommentService;
<<<<<<< HEAD
import com.skillconnect.server.service.NotificationService;
=======
>>>>>>> origin/Member02
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
<<<<<<< HEAD
    private final NotificationService notificationService;
=======
>>>>>>> origin/Member02
    
    @Autowired
    public CommentServiceImpl(
            CommentRepository commentRepository,
            PostRepository postRepository,
<<<<<<< HEAD
            UserRepository userRepository, NotificationService notificationService) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
=======
            UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
>>>>>>> origin/Member02
        log.info("CommentServiceImpl initialized");
    }
    
    @Override
    public Comment createComment(Comment comment) {
        log.info("Creating new comment for post ID: {} by user ID: {}", comment.getPost().getPostId(), comment.getUser().getUserId());
        
        Post post = postRepository.findById(comment.getPost().getPostId())
                .orElseThrow(() -> {
                    log.error("Post not found with ID: {}", comment.getPost().getPostId());
                    return new RuntimeException("Post not found with id: " + comment.getPost().getPostId());
                });
        
<<<<<<< HEAD
        User user = userRepository.findById(comment.getUser().getUserId())
=======
        User user = userRepository.findById(comment.getPost().getPostId())
>>>>>>> origin/Member02
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", comment.getUser().getUserId());
                    return new RuntimeException("User not found with id: " + comment.getUser().getUserId());
                });
        
        comment.setPost(post);
        comment.setUser(user);
<<<<<<< HEAD

        //notificationService.createNotification(new Notification(post.getUser(), user.getFirstName() + " " + user.getLastName() + " commented on your post : " + post.getDescription()));
=======
        // Note: The @PrePersist will handle setting createdAt and updatedAt
>>>>>>> origin/Member02
        
        Comment savedComment = commentRepository.save(comment);
        log.info("Comment created successfully with ID: {}", savedComment.getCommentId());
        return savedComment;
    }
    
    @Override
    public Optional<Comment> findById(int commentId) {
        log.debug("Finding comment by ID: {}", commentId);
        return commentRepository.findById(commentId);
    }
    
    @Override
    public List<Comment> findCommentsByPostId(int postId) {
        log.debug("Finding comments for post ID: {}", postId);
        List<Comment> comments = commentRepository.findByPost_PostId(postId);
        log.debug("Found {} comments for post ID: {}", comments.size(), postId);
        return comments;
    }
    
    @Override
<<<<<<< HEAD
    public List<Comment> findCommentsByUserId(int id) {
        log.debug("Finding comments by user ID: {}", id);
        List<Comment> comments = commentRepository.findByUser_UserId(id);
        log.debug("Found {} comments by user ID: {}", comments.size(), id);
=======
    public List<Comment> findCommentsByUserId(User user) {
        log.debug("Finding comments by user ID: {}", user.getUserId());
        List<Comment> comments = commentRepository.findByUser_UserId(user.getUserId());
        log.debug("Found {} comments by user ID: {}", comments.size(), user.getUserId());
>>>>>>> origin/Member02
        return comments;
    }
    
    @Override
    public Comment updateComment(Comment comment) {
        log.info("Updating comment with ID: {}", comment.getCommentId());
        if (!commentRepository.existsById(comment.getCommentId())) {
            log.error("Comment not found with ID: {}", comment.getCommentId());
            throw new RuntimeException("Comment not found with id: " + comment.getCommentId());
        }
        
        comment.setUpdatedAt(LocalDateTime.now());
        Comment updatedComment = commentRepository.save(comment);
        log.info("Comment updated successfully: {}", comment.getCommentId());
        return updatedComment;
    }
    
    @Override
    public void deleteComment(int commentId) {
        log.info("Deleting comment with ID: {}", commentId);
        commentRepository.deleteById(commentId);
        log.info("Comment deleted successfully: {}", commentId);
    }
    
}
