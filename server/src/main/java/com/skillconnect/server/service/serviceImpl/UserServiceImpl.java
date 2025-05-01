package com.skillconnect.server.service.serviceImpl;

<<<<<<< HEAD
<<<<<<< HEAD
import com.skillconnect.server.model.User;
import com.skillconnect.server.repository.FollowRepository;
import com.skillconnect.server.repository.UserRepository;
import com.skillconnect.server.security.JwtTokenUtil;
import com.skillconnect.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
=======
=======
>>>>>>> origin/Member04
import com.skillconnect.server.model.Follow;
import com.skillconnect.server.model.User;
import com.skillconnect.server.repository.FollowRepository;
import com.skillconnect.server.repository.UserRepository;
import com.skillconnect.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.log4j.Log4j2;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
=======
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
>>>>>>> origin/Member02
=======
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
>>>>>>> origin/Member04

@Log4j2
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;
<<<<<<< HEAD
<<<<<<< HEAD
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           FollowRepository followRepository, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.followRepository = followRepository;
        this.jwtTokenUtil = jwtTokenUtil;
=======
=======
>>>>>>> origin/Member04
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, 
                          FollowRepository followRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.followRepository = followRepository;
        this.passwordEncoder = passwordEncoder;
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
        log.info("UserServiceImpl initialized");
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user with email: {}", user.getEmail());
<<<<<<< HEAD
<<<<<<< HEAD
=======
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
>>>>>>> origin/Member02
=======
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
>>>>>>> origin/Member04
        User savedUser = userRepository.save(user);
        log.info("User saved successfully with ID: {}", savedUser.getUserId());
        return savedUser;
    }

    @Override
    public Optional<User> findById(int userId) {
        log.debug("Finding user by ID: {}", userId);
        return userRepository.findById(userId);
    }

    @Override
    public User findByEmail(String email) {
        log.debug("Finding user by email: {}", email);
        try {
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new RuntimeException("User not found with email: " + email);
            }
            log.debug("User found with email: {}", email);
            return user;
        } catch (RuntimeException e) {
            log.error("Failed to find user with email: {}", email, e);
            throw e;
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
    
>>>>>>> origin/Member02
=======
    
>>>>>>> origin/Member04

    @Override
    public List<User> findAllUsers() {
        log.debug("Retrieving all users");
        List<User> users = userRepository.findAll();
        log.debug("Found {} users", users.size());
        return users;
    }

    @Override
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/Member04
    public User updateUser(User user) {
        log.info("Updating user with ID: {}", user.getUserId());
        // Check if user exists
        if (!userRepository.existsById(user.getUserId())) {
            log.error("User not found with ID: {}", user.getUserId());
            throw new RuntimeException("User not found with id: " + user.getUserId());
        }
        User updatedUser = userRepository.save(user);
        log.info("User updated successfully: {}", user.getUserId());
        return updatedUser;
    }

    @Override
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    public void deleteUser(int userId) {
        log.info("Deleting user with ID: {}", userId);
        userRepository.deleteById(userId);
        log.info("User deleted successfully: {}", userId);
    }

    @Override
    public boolean existsByEmail(String email) {
        log.debug("Checking if user exists with email: {}", email);
        boolean exists = userRepository.existsByEmail(email);
        log.debug("User exists with email {}: {}", email, exists);
        return exists;
    }

    @Override
    public boolean existsByUsername(String username) {
        log.debug("Checking if user exists with username: {}", username);
        boolean exists = userRepository.existsByUsername(username);
        log.debug("User exists with username {}: {}", username, exists);
        return exists;
    }

    @Override
<<<<<<< HEAD
<<<<<<< HEAD
    public User updateUser(int userid, User user) {
        log.info("Updating profile for user ID: {}", userid);
        User userExist = userRepository.findById(userid)
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", userid);
                    return new RuntimeException("User not found with id: " + userid);
                });
        
        if (user.getFirstName() != null) {
            log.debug("Updating first name for user ID: {}", userid);
            userExist.setFirstName(user.getFirstName());
        }
        
        if (user.getLastName() != null) {
            log.debug("Updating last name for user ID: {}", userid);
            userExist.setLastName(user.getLastName());
        }
        
        if (user.getBio() != null) {
            log.debug("Updating bio for user ID: {}", userid);
            userExist.setBio(user.getBio());
        }
        
        if (user.getProfileImage() != null) {
            log.debug("Updating profile image for user ID: {}", userid);
            userExist.setProfileImage(user.getProfileImage());
        }
        
        User updatedUser = userRepository.save(userExist);
        log.info("Profile updated successfully for user ID: {}", userid);
=======
=======
>>>>>>> origin/Member04
    public List<User> getFollowers(int userId) {
        log.debug("Getting followers for user ID: {}", userId);
        // Get all follows where the target user is the specified user
        List<Follow> followers = followRepository.findByFollower_userid(userId);
        
        // Extract the follower users from the follows
        List<User> followerUsers = followers.stream()
                .map(follow -> userRepository.findById(follow.getFollower().getUserId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        
        log.debug("Found {} followers for user ID: {}", followerUsers.size(), userId);
        return followerUsers;
    }

    @Override
    public List<User> getFollowing(int userId) {
        log.debug("Getting following for user ID: {}", userId);
        List<Follow> following = followRepository.findByFollowing_userid(userId);
        
        List<User> followingUsers = following.stream()
                .<Optional<User>>map(follow -> userRepository.findById(follow.getFollowing().getUserId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        
        log.debug("Found {} following for user ID: {}", followingUsers.size(), userId);
        return followingUsers;
    }

    @Override
    public User updateProfile(int userId, String firstName, String lastName, String bio, String profileImage) {
        log.info("Updating profile for user ID: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", userId);
                    return new RuntimeException("User not found with id: " + userId);
                });
        
        if (firstName != null) {
            log.debug("Updating first name for user ID: {}", userId);
            user.setFirstName(firstName);
        }
        
        if (lastName != null) {
            log.debug("Updating last name for user ID: {}", userId);
            user.setLastName(lastName);
        }
        
        if (bio != null) {
            log.debug("Updating bio for user ID: {}", userId);
            user.setBio(bio);
        }
        
        if (profileImage != null) {
            log.debug("Updating profile image for user ID: {}", userId);
            user.setProfileImage(profileImage);
        }
        
        User updatedUser = userRepository.save(user);
        log.info("Profile updated successfully for user ID: {}", userId);
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
        return updatedUser;
    }

    @Override
    public boolean changePassword(int userId, String currentPassword, String newPassword) {
        log.info("Attempting to change password for user ID: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", userId);
                    return new RuntimeException("User not found with id: " + userId);
                });
<<<<<<< HEAD
<<<<<<< HEAD
        user.setPassword(newPassword);
=======
=======
>>>>>>> origin/Member04
        
        // Verify current password
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            log.warn("Password change failed for user ID: {} - Current password doesn't match", userId);
            return false;
        }
        
        // Update password
        user.setPassword(passwordEncoder.encode(newPassword));
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
        userRepository.save(user);
        
        log.info("Password changed successfully for user ID: {}", userId);
        return true;
    }
<<<<<<< HEAD
<<<<<<< HEAD

    @Override
    public Map<String, Object> login(User userDetails) {
        log.info("Attempting to login with username: {}", userDetails.getEmail());
        User user = userRepository.findByEmail(userDetails.getEmail());
        if (user != null && user.getPassword().equals(userDetails.getPassword())) {

            String token = jwtTokenUtil.generateToken(user.getEmail());

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", user);

            log.info("Login successful for user: {}", userDetails.getEmail());
            return response;
        } else {
            log.warn("Login failed for user: {}", userDetails.getEmail());
            return null;
        }
    }
=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
}