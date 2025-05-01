<<<<<<< HEAD
package com.skillconnect.server.service.impl;
=======
package com.skillconnect.server.service.serviceImpl;
>>>>>>> origin/Member02

import com.skillconnect.server.model.LearningPlan;
import com.skillconnect.server.model.LearningUpdate;
import com.skillconnect.server.model.UpdateTemplate;
import com.skillconnect.server.model.User;
import com.skillconnect.server.repository.LearningPlanRepository;
import com.skillconnect.server.repository.LearningUpdateRepository;
import com.skillconnect.server.repository.UpdateTemplateRepository;
import com.skillconnect.server.repository.UserRepository;
import com.skillconnect.server.service.LearningUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@Transactional
public class LearningUpdateServiceImpl implements LearningUpdateService {

    private final LearningUpdateRepository learningUpdateRepository;
    private final LearningPlanRepository learningPlanRepository;
    private final UserRepository userRepository;
    private final UpdateTemplateRepository updateTemplateRepository;
    
    @Autowired
    public LearningUpdateServiceImpl(
            LearningUpdateRepository learningUpdateRepository,
            LearningPlanRepository learningPlanRepository,
            UserRepository userRepository,
            UpdateTemplateRepository updateTemplateRepository) {
        this.learningUpdateRepository = learningUpdateRepository;
        this.learningPlanRepository = learningPlanRepository;
        this.userRepository = userRepository;
        this.updateTemplateRepository = updateTemplateRepository;
        log.info("LearningUpdateServiceImpl initialized");
    }
    
    @Override
<<<<<<< HEAD
    public LearningUpdate createUpdate(LearningUpdate update, Long userId, Long planId) {
        log.info("Creating new learning update for user ID: {} and plan ID: {}", userId, planId);
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", userId);
                    return new RuntimeException("User not found with id: " + userId);
=======
    public LearningUpdate createUpdate(LearningUpdate update, int planId) {
        log.info("Creating new learning update for user ID: {} and plan ID: {}", update.getUser().getUserId(), planId);
        
        User user = userRepository.findById(update.getUser().getUserId())
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", update.getUser().getUserId());
                    return new RuntimeException("User not found with id: " + update.getUser().getUserId());
>>>>>>> origin/Member02
                });
        
        LearningPlan plan = learningPlanRepository.findById(planId)
                .orElseThrow(() -> {
                    log.error("Learning plan not found with ID: {}", planId);
                    return new RuntimeException("Learning plan not found with id: " + planId);
                });
        
<<<<<<< HEAD
        // Verify the plan belongs to the user
        if (!plan.getUser().getId().equals(userId)) {
            log.error("Learning plan ID: {} does not belong to user ID: {}", planId, userId);
            throw new RuntimeException("Learning plan does not belong to this user");
        }
        
        update.setUser(user);
        update.setLearningPlan(plan);
        // The @PrePersist will handle setting createdAt and updatedAt
        
        LearningUpdate savedUpdate = learningUpdateRepository.save(update);
        log.info("Learning update created successfully with ID: {}", savedUpdate.getId());
=======
        // Verify the plan beints to the user
        if (plan.getUser().getUserId() != update.getUser().getUserId()) {
            log.error("Learning plan ID: {} does not beint to user ID: {}", planId, update.getUser().getUserId());
            throw new RuntimeException("Learning plan does not beint to this user");
        }
        
        update.setUser(user);
        // The @PrePersist will handle setting createdAt and updatedAt
        
        LearningUpdate savedUpdate = learningUpdateRepository.save(update);
        log.info("Learning update created successfully with ID: {}", savedUpdate.getUpdateId());
>>>>>>> origin/Member02
        return savedUpdate;
    }
    
    @Override
<<<<<<< HEAD
    public LearningUpdate createUpdateFromTemplate(Long templateId, Long userId, Long planId, String content) {
        log.info("Creating learning update from template ID: {} for user ID: {} and plan ID: {}", 
                templateId, userId, planId);
        
        UpdateTemplate template = updateTemplateRepository.findById(templateId)
                .orElseThrow(() -> {
                    log.error("Update template not found with ID: {}", templateId);
                    return new RuntimeException("Update template not found with id: " + templateId);
                });
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", userId);
                    return new RuntimeException("User not found with id: " + userId);
                });
        
        LearningPlan plan = learningPlanRepository.findById(planId)
                .orElseThrow(() -> {
                    log.error("Learning plan not found with ID: {}", planId);
                    return new RuntimeException("Learning plan not found with id: " + planId);
                });
        
        // Verify the plan belongs to the user
        if (!plan.getUser().getId().equals(userId)) {
            log.error("Learning plan ID: {} does not belong to user ID: {}", planId, userId);
            throw new RuntimeException("Learning plan does not belong to this user");
        }
        
        LearningUpdate update = new LearningUpdate();
        update.setTitle(template.getTitle());
        update.setContent(content);
        update.setUser(user);
        update.setLearningPlan(plan);
        update.setTemplate(template);
        
        LearningUpdate savedUpdate = learningUpdateRepository.save(update);
        log.info("Learning update created from template successfully with ID: {}", savedUpdate.getId());
=======
    public LearningUpdate createUpdateFromTemplate(UpdateTemplate template, LearningPlan plan) {
        log.info("Creating learning update from template ID: {} for user ID: {} and plan ID: {}", 
                template.getTemplateId(), plan.getUser().getUserId(), plan.getPlanId());
        
        UpdateTemplate templateExist = updateTemplateRepository.findById(template.getTemplateId())
                .orElseThrow(() -> {
                    log.error("Update template not found with ID: {}", template.getTemplateId());
                    return new RuntimeException("Update template not found with id: " + template.getTemplateId());
                });
        
        User user = userRepository.findById(plan.getUser().getUserId())
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", plan.getUser().getUserId());
                    return new RuntimeException("User not found with id: " + plan.getUser().getUserId());
                });
        
        LearningPlan planExist = learningPlanRepository.findById(plan.getUser().getUserId())
                .orElseThrow(() -> {
                    log.error("Learning plan not found with ID: {}", plan.getPlanId());
                    return new RuntimeException("Learning plan not found with id: " + plan.getPlanId());
                });
        
        // Verify the plan beints to the user
        if (planExist.getUser().getUserId() != plan.getUser().getUserId()) {
            log.error("Learning plan ID: {} does not beint to user ID: {}", plan.getPlanId(), plan.getUser().getUserId());
            throw new RuntimeException("Learning plan does not beint to this user");
        }
        
        LearningUpdate update = new LearningUpdate();
        update.setTitle(templateExist.getName());
        update.setDescription(templateExist.getDescription());
        update.setUser(user);
        
        LearningUpdate savedUpdate = learningUpdateRepository.save(update);
        log.info("Learning update created from template successfully with ID: {}", savedUpdate.getUpdateId());
>>>>>>> origin/Member02
        return savedUpdate;
    }
    
    @Override
<<<<<<< HEAD
    public Optional<LearningUpdate> findById(Long updateId) {
=======
    public Optional<LearningUpdate> findById(int updateId) {
>>>>>>> origin/Member02
        log.debug("Finding learning update by ID: {}", updateId);
        return learningUpdateRepository.findById(updateId);
    }
    
    @Override
<<<<<<< HEAD
    public List<LearningUpdate> findUpdatesByUserId(Long userId) {
        log.debug("Finding learning updates for user ID: {}", userId);
        List<LearningUpdate> updates = learningUpdateRepository.findByUserId(userId);
=======
    public List<LearningUpdate> findUpdatesByUserId(int userId) {
        log.debug("Finding learning updates for user ID: {}", userId);
        List<LearningUpdate> updates = learningUpdateRepository.findByUser_UserId(userId);
>>>>>>> origin/Member02
        log.debug("Found {} updates for user ID: {}", updates.size(), userId);
        return updates;
    }
    
    @Override
<<<<<<< HEAD
    public List<LearningUpdate> findUpdatesByPlanId(Long planId) {
        log.debug("Finding learning updates for plan ID: {}", planId);
        List<LearningUpdate> updates = learningUpdateRepository.findByLearningPlanId(planId);
        log.debug("Found {} updates for plan ID: {}", updates.size(), planId);
        return updates;
    }
    
    @Override
    public LearningUpdate updateLearningUpdate(LearningUpdate update) {
        log.info("Updating learning update with ID: {}", update.getId());
        if (!learningUpdateRepository.existsById(update.getId())) {
            log.error("Learning update not found with ID: {}", update.getId());
            throw new RuntimeException("Learning update not found with id: " + update.getId());
=======
    public LearningUpdate updateLearningUpdate(LearningUpdate update) {
        log.info("Updating learning update with ID: {}", update.getUpdateId());
        if (!learningUpdateRepository.existsById(update.getUpdateId())) {
            log.error("Learning update not found with ID: {}", update.getUpdateId());
            throw new RuntimeException("Learning update not found with id: " + update.getUpdateId());
>>>>>>> origin/Member02
        }
        
        update.setUpdatedAt(LocalDateTime.now());
        LearningUpdate updatedUpdate = learningUpdateRepository.save(update);
<<<<<<< HEAD
        log.info("Learning update updated successfully: {}", update.getId());
=======
        log.info("Learning update updated successfully: {}", update.getUpdateId());
>>>>>>> origin/Member02
        return updatedUpdate;
    }
    
    @Override
<<<<<<< HEAD
    public void deleteUpdate(Long updateId) {
=======
    public void deleteUpdate(int updateId) {
>>>>>>> origin/Member02
        log.info("Deleting learning update with ID: {}", updateId);
        learningUpdateRepository.deleteById(updateId);
        log.info("Learning update deleted successfully: {}", updateId);
    }
<<<<<<< HEAD
    
    @Override
    public List<LearningUpdate> findRecentUpdates(Long userId, int limit) {
        log.debug("Finding recent {} learning updates for user ID: {}", limit, userId);
        List<LearningUpdate> recentUpdates = learningUpdateRepository.findByUserIdOrderByCreatedAtDesc(userId, limit);
        log.debug("Found {} recent updates for user ID: {}", recentUpdates.size(), userId);
        return recentUpdates;
    }
    
    @Override
    public List<LearningUpdate> findUpdatesByTemplateId(Long templateId) {
        log.debug("Finding learning updates for template ID: {}", templateId);
        List<LearningUpdate> updates = learningUpdateRepository.findByTemplateId(templateId);
        log.debug("Found {} updates for template ID: {}", updates.size(), templateId);
        return updates;
    }
    
    @Override
    public int countUpdatesByPlanId(Long planId) {
        log.debug("Counting learning updates for plan ID: {}", planId);
        int count = learningUpdateRepository.countByLearningPlanId(planId);
        log.debug("Found {} updates for plan ID: {}", count, planId);
        return count;
    }
    
    @Override
    public List<LearningUpdate> findAllUpdates() {
        log.debug("Retrieving all learning updates");
        List<LearningUpdate> updates = learningUpdateRepository.findAll();
        log.debug("Found {} learning updates", updates.size());
        return updates;
    }
=======

>>>>>>> origin/Member02
}
