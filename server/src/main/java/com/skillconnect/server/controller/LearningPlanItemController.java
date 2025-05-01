package com.skillconnect.server.controller;

import com.skillconnect.server.model.LearningPlanItem;
import com.skillconnect.server.service.LearningPlanItemService;
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

import java.util.List;

@RestController
@RequestMapping("/api/learning-plan-items")
<<<<<<< HEAD
<<<<<<< HEAD
=======
@AllArgsConstructor(onConstructor = @__(@Autowired))
>>>>>>> origin/Member02
=======
@AllArgsConstructor(onConstructor = @__(@Autowired))
>>>>>>> origin/Member04
public class LearningPlanItemController {

    private final LearningPlanItemService itemService;

<<<<<<< HEAD
<<<<<<< HEAD
    @Autowired
    public LearningPlanItemController(LearningPlanItemService itemService) {
        this.itemService = itemService;
    }

=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    @PostMapping
    public ResponseEntity<LearningPlanItem> createItem(@RequestBody LearningPlanItem item) {
        LearningPlanItem createdItem = itemService.createItem(item);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningPlanItem> getItemById(@PathVariable int id) {
        return itemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<List<LearningPlanItem>> getItemsByPlanId(@PathVariable int planId) {
        return ResponseEntity.ok(itemService.findItemsByPlanId(planId));
    }

    @PutMapping
    public ResponseEntity<LearningPlanItem> updateItem(@RequestBody LearningPlanItem item) {
        return ResponseEntity.ok(itemService.updateItem(item));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<LearningPlanItem> markAsCompleted(@PathVariable int id) {
        return ResponseEntity.ok(itemService.markItemAsCompleted(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}

