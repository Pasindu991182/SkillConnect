package com.skillconnect.server.controller;

import com.skillconnect.server.model.Follow;
import com.skillconnect.server.service.FollowService;
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

@RestController
@RequestMapping("/api/follow")
<<<<<<< HEAD
<<<<<<< HEAD
=======
@AllArgsConstructor(onConstructor = @__(@Autowired))
>>>>>>> origin/Member02
=======
@AllArgsConstructor(onConstructor = @__(@Autowired))
>>>>>>> origin/Member04
public class FollowController {

    private final FollowService followService;

<<<<<<< HEAD
<<<<<<< HEAD
    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    @PostMapping
    public ResponseEntity<Follow> followUser(@RequestBody Follow follow) {
        Follow created = followService.followUser(follow);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping
    public ResponseEntity<Void> unfollowUser(@RequestBody Follow follow) {
        followService.unfollowUser(follow);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<Integer> getFollowerCount(@PathVariable int userId) {
        return ResponseEntity.ok(followService.getFollowerCount(userId));
    }

    @GetMapping("/{userId}/following/count")
    public ResponseEntity<Integer> getFollowingCount(@PathVariable int userId) {
        return ResponseEntity.ok(followService.getFollowingCount(userId));
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/Member04

    @GetMapping("/is-following")
    public ResponseEntity<Boolean> isFollowing(
            @RequestParam int followerId,
            @RequestParam int followingId) {
        return ResponseEntity.ok(followService.isFollowing(followerId, followingId));
    }
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
}

