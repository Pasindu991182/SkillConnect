package com.skillconnect.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> origin/Member02
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> origin/Member04

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LearningPlanItems")
public class LearningPlanItem {
<<<<<<< HEAD
<<<<<<< HEAD

=======
    
>>>>>>> origin/Member02
=======
    
>>>>>>> origin/Member04
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;
<<<<<<< HEAD
<<<<<<< HEAD

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private LearningPlan learningPlan;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "is_complete", nullable = false)
    private boolean isComplete = false;

=======
=======
>>>>>>> origin/Member04
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private LearningPlan learningPlan;
    
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @ElementCollection
    @CollectionTable(
        name = "learning_plan_item_resources",
        joinColumns = @JoinColumn(name = "item_id")
    )
    @Column(name = "resource")
    private List<String> resources = new ArrayList<>();
    
    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;
    
    @Column(name = "status", nullable = false, length = 20)
    private String status = "pending";
    
    @Column(name = "completion_date")
    private LocalDate completionDate;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
}
