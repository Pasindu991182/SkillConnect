package com.skillconnect.server.controller;

import com.skillconnect.server.model.User;
import com.skillconnect.server.service.UserService;
<<<<<<< HEAD
<<<<<<< HEAD
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
=======
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> origin/Member02
=======
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> origin/Member04
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Map;

@RestController
@RequestMapping("/api/users")
=======
=======
>>>>>>> origin/Member04

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
public class UserController {

    private final UserService userService;

<<<<<<< HEAD
<<<<<<< HEAD
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
=======
    @PostMapping
>>>>>>> origin/Member02
=======
    @PostMapping
>>>>>>> origin/Member04
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Map<String, Object> response = userService.login(user);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/Member04
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/email/{email}")
    public ResponseEntity<Boolean> checkEmailExists(@PathVariable String email) {
        return ResponseEntity.ok(userService.existsByEmail(email));
    }

    @GetMapping("/exists/username/{username}")
    public ResponseEntity<Boolean> checkUsernameExists(@PathVariable String username) {
        return ResponseEntity.ok(userService.existsByUsername(username));
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @PutMapping("/{id}/update")
    public ResponseEntity<User> updateUser(
            @PathVariable int id,
            @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
=======
=======
>>>>>>> origin/Member04
    @GetMapping("/{id}/followers")
    public ResponseEntity<List<User>> getFollowers(@PathVariable int id) {
        return ResponseEntity.ok(userService.getFollowers(id));
    }

    @GetMapping("/{id}/following")
    public ResponseEntity<List<User>> getFollowing(@PathVariable int id) {
        return ResponseEntity.ok(userService.getFollowing(id));
    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<User> updateProfile(
            @PathVariable int id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam(required = false) String bio,
            @RequestParam(required = false) String profileImage) {
        return ResponseEntity.ok(userService.updateProfile(id, firstName, lastName, bio, profileImage));
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<Boolean> changePassword(
            @PathVariable int id,
            @RequestParam String currentPassword,
            @RequestParam String newPassword) {
        return ResponseEntity.ok(userService.changePassword(id, currentPassword, newPassword));
    }
}

