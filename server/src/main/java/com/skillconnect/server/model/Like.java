package com.skillconnect.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Likes", uniqueConstraints = {
<<<<<<< HEAD
<<<<<<< HEAD
        @UniqueConstraint(columnNames = {"user_id", "post_id"})
})
public class Like {

=======
=======
>>>>>>> origin/Member04
    @UniqueConstraint(columnNames = {"user_id", "post_id"})
})
public class Like {
    
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private int likeId;
<<<<<<< HEAD
<<<<<<< HEAD

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

=======
=======
>>>>>>> origin/Member04
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
<<<<<<< HEAD
<<<<<<< HEAD

=======
    
>>>>>>> origin/Member02
=======
    
>>>>>>> origin/Member04
}
