package com.skillconnect.server.service;

import com.skillconnect.server.model.Media;
<<<<<<< HEAD
<<<<<<< HEAD
import com.skillconnect.server.model.Post;
=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04

import java.util.List;
import java.util.Optional;

public interface MediaService {
<<<<<<< HEAD
<<<<<<< HEAD
    
    Media saveMedia(Media media);
    
    Optional<Media> findById(Long mediaId);
    
    List<Media> findMediaByPost(Post post);
    
    List<Media> findMediaByPostId(Long postId);
    
    List<Media> findMediaByType(String mediaType);
    
    void deleteMedia(Long mediaId);
    
    void deleteMediaByPost(Long postId);
=======
=======
>>>>>>> origin/Member04

    Media storeMedia(Media media);

    Media attachMediaToPost(int mediaId, int postId);

    List<Media> findMediaByPostId(int postId);

    Optional<Media> findById(int mediaId);
    
    List<Media> findMediaByType(String mediaType);
    
    void deleteMedia(int mediaId);
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
}
