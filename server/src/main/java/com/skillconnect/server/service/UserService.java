package com.skillconnect.server.service;

import com.skillconnect.server.model.User;

import java.util.List;
<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> origin/Member02
import java.util.Optional;


public interface UserService {
    
    User saveUser(User user);
<<<<<<< HEAD
    Map<String, Object> login(User user);
    Optional<User> findById(int userId);
    User findByEmail(String email);
    List<User> findAllUsers();
    User updateUser(int userid, User user);
    void deleteUser(int userId);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
=======
    Optional<User> findById(int userId);
    User findByEmail(String email);
    List<User> findAllUsers();
    User updateUser(User user);
    void deleteUser(int userId);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    List<User> getFollowers(int userId);
    List<User> getFollowing(int userId);
    User updateProfile(int userId, String firstName, String lastName, String bio, String profileImage);
>>>>>>> origin/Member02
    boolean changePassword(int userId, String currentPassword, String newPassword);
}
