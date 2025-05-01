<<<<<<< HEAD
<<<<<<< HEAD
package com.skillconnect.server.service.impl;

import com.skillconnect.server.model.Media;
import com.skillconnect.server.model.Post;
import com.skillconnect.server.model.User;
import com.skillconnect.server.repository.MediaRepository;
import com.skillconnect.server.repository.PostRepository;
import com.skillconnect.server.repository.UserRepository;
=======
=======
>>>>>>> origin/Member04
package com.skillconnect.server.service.serviceImpl;

import com.skillconnect.server.model.Media;
import com.skillconnect.server.model.Post;
import com.skillconnect.server.repository.MediaRepository;
import com.skillconnect.server.repository.PostRepository;
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
import com.skillconnect.server.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;
=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
<<<<<<< HEAD
<<<<<<< HEAD
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
=======
import java.util.List;
import java.util.Optional;
>>>>>>> origin/Member02
=======
import java.util.List;
import java.util.Optional;
>>>>>>> origin/Member04

@Log4j2
@Service
@Transactional
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;
    private final PostRepository postRepository;
<<<<<<< HEAD
<<<<<<< HEAD
    private final UserRepository userRepository;
    private final Path fileStorageLocation;
=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    
    @Autowired
    public MediaServiceImpl(
            MediaRepository mediaRepository,
<<<<<<< HEAD
<<<<<<< HEAD
            PostRepository postRepository,
            UserRepository userRepository,
            String uploadDir) {
        this.mediaRepository = mediaRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        
        this.fileStorageLocation = Paths.get(uploadDir)
                .toAbsolutePath().normalize();
        
        try {
            Files.createDirectories(this.fileStorageLocation);
            log.info("Created file storage directory: {}", this.fileStorageLocation);
        } catch (IOException ex) {
            log.error("Could not create the directory where the uploaded files will be stored", ex);
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored", ex);
        }
=======
=======
>>>>>>> origin/Member04
            PostRepository postRepository) {
        this.mediaRepository = mediaRepository;
        this.postRepository = postRepository;
        
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
        
        log.info("MediaServiceImpl initialized");
    }
    
    @Override
<<<<<<< HEAD
<<<<<<< HEAD
    public Media storeMedia(MultipartFile file, Long userId, String mediaType) {
        log.info("Storing media file for user ID: {}, media type: {}", userId, mediaType);
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", userId);
                    return new RuntimeException("User not found with id: " + userId);
                });
        
        // Normalize file name
        String originalFileName = file.getOriginalFilename();
        String fileExtension = "";
        if (originalFileName != null && originalFileName.contains(".")) {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }
        
        // Generate unique file name
        String fileName = UUID.randomUUID().toString() + fileExtension;
        
        try {
            // Copy file to the target location
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            // Create media entity
            Media media = new Media();
            media.setFileName(fileName);
            media.setOriginalFileName(originalFileName);
            media.setFileType(file.getContentType());
            media.setFileSize(file.getSize());
            media.setFilePath(targetLocation.toString());
            media.setMediaType(mediaType);
            media.setUser(user);
            // The @PrePersist will handle setting createdAt
            
            Media savedMedia = mediaRepository.save(media);
            log.info("Media stored successfully with ID: {}", savedMedia.getId());
            return savedMedia;
            
        } catch (IOException ex) {
            log.error("Could not store file {}. Please try again!", fileName, ex);
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    
    @Override
    public Media attachMediaToPost(Long mediaId, Long postId) {
=======
=======
>>>>>>> origin/Member04
    public Media storeMedia(Media media) {
        log.info("Storing media for post ID: {}, media type: {}", media.getPost().getPostId(), media.getMediaType());
    
        postRepository.findByPostId(media.getPost().getPostId())
                .orElseThrow(() -> {
                    log.error("Post not found with ID: {}", media.getPost().getPostId());
                    return new RuntimeException("Post not found with id: " + media.getPost().getPostId());
                });
    
                Media savedMedia = mediaRepository.save(media);
                log.info("Media stored successfully with ID: {}", savedMedia.getMediaId());
                return savedMedia;
    }
    
    
    @Override
    public Media attachMediaToPost(int mediaId, int postId) {
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
        log.info("Attaching media ID: {} to post ID: {}", mediaId, postId);
        
        Media media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> {
                    log.error("Media not found with ID: {}", mediaId);
                    return new RuntimeException("Media not found with id: " + mediaId);
                });
        
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> {
                    log.error("Post not found with ID: {}", postId);
                    return new RuntimeException("Post not found with id: " + postId);
                });
        
        media.setPost(post);
        Media updatedMedia = mediaRepository.save(media);
        log.info("Media attached successfully to post ID: {}", postId);
        return updatedMedia;
    }
    
    @Override
<<<<<<< HEAD
<<<<<<< HEAD
    public Optional<Media> findById(Long mediaId) {
=======
    public Optional<Media> findById(int mediaId) {
>>>>>>> origin/Member02
=======
    public Optional<Media> findById(int mediaId) {
>>>>>>> origin/Member04
        log.debug("Finding media by ID: {}", mediaId);
        return mediaRepository.findById(mediaId);
    }
    
    @Override
<<<<<<< HEAD
<<<<<<< HEAD
    public List<Media> findMediaByUserId(Long userId) {
        log.debug("Finding media for user ID: {}", userId);
        List<Media> mediaList = mediaRepository.findByUserId(userId);
        log.debug("Found {} media items for user ID: {}", mediaList.size(), userId);
        return mediaList;
    }
    
    @Override
    public List<Media> findMediaByPostId(Long postId) {
=======
    public List<Media> findMediaByPostId(int postId) {
>>>>>>> origin/Member02
=======
    public List<Media> findMediaByPostId(int postId) {
>>>>>>> origin/Member04
        log.debug("Finding media for post ID: {}", postId);
        List<Media> mediaList = mediaRepository.findByPostId(postId);
        log.debug("Found {} media items for post ID: {}", mediaList.size(), postId);
        return mediaList;
    }
    
    @Override
<<<<<<< HEAD
<<<<<<< HEAD
    public void deleteMedia(Long mediaId) {
=======
    public void deleteMedia(int mediaId) {
>>>>>>> origin/Member02
=======
    public void deleteMedia(int mediaId) {
>>>>>>> origin/Member04
        log.info("Deleting media with ID: {}", mediaId);
        
        Media media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> {
                    log.error("Media not found with ID: {}", mediaId);
                    return new RuntimeException("Media not found with id: " + mediaId);
                });
        
        // Delete the file from storage
        try {
            Path filePath = Paths.get(media.getFilePath());
            Files.deleteIfExists(filePath);
            log.debug("Deleted file from storage: {}", media.getFilePath());
        } catch (IOException ex) {
            log.error("Error deleting file: {}", media.getFilePath(), ex);
            // Continue with deleting the database record even if file deletion fails
        }
        
        // Delete the database record
        mediaRepository.delete(media);
        log.info("Media deleted successfully: {}", mediaId);
    }
    
    @Override
    public List<Media> findMediaByType(String mediaType) {
        log.debug("Finding media by type: {}", mediaType);
        List<Media> mediaList = mediaRepository.findByMediaType(mediaType);
        log.debug("Found {} media items of type: {}", mediaList.size(), mediaType);
        return mediaList;
<<<<<<< HEAD
<<<<<<< HEAD
    }
    
    @Override
    public List<Media> findRecentMedia(int limit) {
        log.debug("Finding recent {} media items", limit);
        List<Media> recentMedia = mediaRepository.findTopNByOrderByCreatedAtDesc(limit);
        log.debug("Found {} recent media items", recentMedia.size());
        return recentMedia;
    }
    
    @Override
    public byte[] getMediaContent(Long mediaId) {
        log.debug("Getting content for media ID: {}", mediaId);
        
        Media media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> {
                    log.error("Media not found with ID: {}", mediaId);
                    return new RuntimeException("Media not found with id: " + mediaId);
                });
        
        try {
            Path filePath = Paths.get(media.getFilePath());
            byte[] content = Files.readAllBytes(filePath);
            log.debug("Successfully read content for media ID: {}", mediaId);
            return content;
        } catch (IOException ex) {
            log.error("Error reading file content for media ID: {}", mediaId, ex);
            throw new RuntimeException("Could not read file content", ex);
        }
    }
    
    @Override
    public Media updateMediaMetadata(Long mediaId, String title, String description) {
        log.info("Updating metadata for media ID: {}", mediaId);
        
        Media media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> {
                    log.error("Media not found with ID: {}", mediaId);
                    return new RuntimeException("Media not found with id: " + mediaId);
                });
        
        if (title != null) {
            media.setTitle(title);
        }
        
        if (description != null) {
            media.setDescription(description);
        }
        
        Media updatedMedia = mediaRepository.save(media);
        log.info("Media metadata updated successfully for ID: {}", mediaId);
        return updatedMedia;
    }
=======
    } 
>>>>>>> origin/Member02
=======
    } 
>>>>>>> origin/Member04
}
