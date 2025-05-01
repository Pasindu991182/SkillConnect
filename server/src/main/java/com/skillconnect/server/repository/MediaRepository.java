package com.skillconnect.server.repository;

import com.skillconnect.server.model.Media;
import com.skillconnect.server.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
public interface MediaRepository extends JpaRepository<Media, int> {
=======
public interface MediaRepository extends JpaRepository<Media, Integer> {
>>>>>>> origin/Member02
=======
public interface MediaRepository extends JpaRepository<Media, Integer> {
>>>>>>> origin/Member04
    List<Media> findByPost(Post post);
    List<Media> findByPostId(int postId);
    List<Media> findByMediaType(String mediaType);
}
