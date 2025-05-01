package com.skillconnect.server.controller;

<<<<<<< HEAD
import com.skillconnect.server.dto.LearningPlanDTO;
import com.skillconnect.server.model.LearningPlan;
import com.skillconnect.server.model.LearningPlanItem;
import com.skillconnect.server.service.LearningPlanService;
=======
import com.skillconnect.server.model.LearningPlan;
import com.skillconnect.server.model.LearningPlanItem;
import com.skillconnect.server.service.LearningPlanService;
import lombok.AllArgsConstructor;
>>>>>>> origin/Member02
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learning-plans")
<<<<<<< HEAD
=======
@AllArgsConstructor(onConstructor = @__(@Autowired))
>>>>>>> origin/Member02
public class LearningPlanController {

    private final LearningPlanService learningPlanService;

<<<<<<< HEAD
    @Autowired
    public LearningPlanController(LearningPlanService learningPlanService) {
        this.learningPlanService = learningPlanService;
    }

    @PostMapping
    public ResponseEntity<LearningPlan> createLearningPlan(@RequestBody LearningPlanDTO dto) {
        LearningPlan created = learningPlanService.createLearningPlan(dto);
=======
    @PostMapping
    public ResponseEntity<LearningPlan> createLearningPlan(@RequestBody LearningPlan learningPlan) {
        LearningPlan created = learningPlanService.createLearningPlan(learningPlan);
>>>>>>> origin/Member02
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<LearningPlanDTO> getLearningPlanById(@PathVariable int id) {
        return ResponseEntity.ok(learningPlanService.findById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LearningPlanDTO>> getLearningPlansByUserId(@PathVariable int userId) {
=======
    public ResponseEntity<LearningPlan> getLearningPlanById(@PathVariable int id) {
        return learningPlanService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LearningPlan>> getLearningPlansByUserId(@PathVariable int userId) {
>>>>>>> origin/Member02
        return ResponseEntity.ok(learningPlanService.findLearningPlansByUserId(userId));
    }

    @PutMapping
    public ResponseEntity<LearningPlan> updateLearningPlan(@RequestBody LearningPlan learningPlan) {
        return ResponseEntity.ok(learningPlanService.updateLearningPlan(learningPlan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLearningPlan(@PathVariable int id) {
        learningPlanService.deleteLearningPlan(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{planId}/items")
    public ResponseEntity<LearningPlanItem> addItemToPlan(
            @RequestBody LearningPlanItem item,
            @PathVariable int planId) {
        LearningPlanItem addedItem = learningPlanService.addItemToPlan(item, planId);
        return ResponseEntity.ok(addedItem);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> removeItemFromPlan(@PathVariable int itemId) {
        learningPlanService.removeItemFromPlan(itemId);
        return ResponseEntity.noContent().build();
    }
}
