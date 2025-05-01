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
@Table(name = "AdminMessages")
public class AdminMessage {
<<<<<<< HEAD
<<<<<<< HEAD

=======
    
>>>>>>> origin/Member02
=======
    
>>>>>>> origin/Member04
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;
<<<<<<< HEAD
<<<<<<< HEAD

    @OneToOne
    @JoinColumn(name = "user_id")
    private User admin;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

=======
=======
>>>>>>> origin/Member04
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User admin;
    
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;
    
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
