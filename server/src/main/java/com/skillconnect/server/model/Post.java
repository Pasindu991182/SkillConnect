package com.skillconnect.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Posts")
public class Post {
<<<<<<< HEAD
<<<<<<< HEAD

=======
    
>>>>>>> origin/Member02
=======
    
>>>>>>> origin/Member04
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;
<<<<<<< HEAD
<<<<<<< HEAD

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "media1")
    private String media1;

    @Column(name = "media2")
    private String media2;

    @Column(name = "media3")
    private String media3;

    @ManyToOne
    @JoinColumn(name = "learning_plan_id")
    private LearningPlan learningPlan;

=======
=======
>>>>>>> origin/Member04
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> mediaList;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "learning_update_id")
    private LearningUpdate learningUpdate;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "learning_plan_id")
    private LearningPlan learningPlan;
    
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
<<<<<<< HEAD
<<<<<<< HEAD

=======
    
>>>>>>> origin/Member02
=======
    
>>>>>>> origin/Member04
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
