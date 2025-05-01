package com.skillconnect.server.service.serviceImpl;

import com.skillconnect.server.model.Like;
<<<<<<< HEAD
import com.skillconnect.server.model.Notification;
=======
>>>>>>> origin/Member02
import com.skillconnect.server.model.Post;
import com.skillconnect.server.model.User;
import com.skillconnect.server.repository.LikeRepository;
import com.skillconnect.server.repository.PostRepository;
import com.skillconnect.server.repository.UserRepository;
import com.skillconnect.server.service.LikeService;
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
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> origin/Member02

@Log4j2
@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
<<<<<<< HEAD
    private final NotificationService notificationService;

=======
    
>>>>>>> origin/Member02
    @Autowired
    public LikeServiceImpl(
            LikeRepository likeRepository,
            PostRepository postRepository,
<<<<<<< HEAD
            UserRepository userRepository, NotificationService notificationService) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        log.info("LikeServiceImpl initialized");
    }

    @Override
    public Like likePost(int postId, int userId) {
        log.info("Creating like for post ID: {} by user ID: {}", postId, userId);

=======
            UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        log.info("LikeServiceImpl initialized");
    }
    
    @Override
    public Like likePost(int userId, int postId) {
        log.info("Creating like for post ID: {} by user ID: {}", postId, userId);
        
>>>>>>> origin/Member02
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", userId);
                    return new RuntimeException("User not found with id: " + userId);
                });
<<<<<<< HEAD

=======
        
>>>>>>> origin/Member02
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> {
                    log.error("Post not found with ID: {}", postId);
                    return new RuntimeException("Post not found with id: " + postId);
                });
<<<<<<< HEAD

        Optional<Like> existingLike = likeRepository.findByUserAndPost(user, post);
        if (existingLike.isPresent()) {
            log.warn("User {} already liked post {}", userId, postId);
            return existingLike.get();
        } else {
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            like.setCreatedAt(LocalDateTime.now());

            //notificationService.createNotification(new Notification(post.getUser(), user.getFirstName() +" " + user.getLastName() + " liked your post : " + post.getDescription()));

            Like savedLike = likeRepository.save(like);
            log.info("Like created successfully with ID: {}", savedLike.getLikeId());
            return savedLike;
        }

    }

    @Override
    public void unlikePost(int postId, int userId) {
        log.info("Removing like for post ID: {} by user ID: {}", postId, userId);

=======
        
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        like.setCreatedAt(LocalDateTime.now());
        
        Like savedLike = likeRepository.save(like);
        log.info("Like created successfully with ID: {}", savedLike.getLikeId());
        return savedLike;
    }
    
    @Override
    public void unlikePost(int userId, int postId) {
        log.info("Removing like for post ID: {} by user ID: {}", postId, userId);
        
>>>>>>> origin/Member02
        Like like = likeRepository.findByUser_UserIdAndPost_PostId(userId, postId)
                .orElseThrow(() -> {
                    log.error("Like not found for post ID: {} by user ID: {}", postId, userId);
                    return new RuntimeException("Like not found");
                });
<<<<<<< HEAD

        likeRepository.delete(like);
        log.info("Like removed successfully");
    }

=======
        
        likeRepository.delete(like);
        log.info("Like removed successfully");
    }
    
>>>>>>> origin/Member02
    @Override
    public List<Like> findLikesByPostId(int postId) {
        log.debug("Finding likes for post ID: {}", postId);
        List<Like> likes = likeRepository.findByPost_PostId(postId);
        log.debug("Found {} likes for post ID: {}", likes.size(), postId);
        return likes;
    }

}
