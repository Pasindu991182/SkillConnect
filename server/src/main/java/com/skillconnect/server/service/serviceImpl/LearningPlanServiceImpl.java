package com.skillconnect.server.service.serviceImpl;

<<<<<<< HEAD
import com.skillconnect.server.dto.LearningPlanDTO;
=======
>>>>>>> origin/Member02
import com.skillconnect.server.model.LearningPlan;
import com.skillconnect.server.model.LearningPlanItem;
import com.skillconnect.server.model.User;
import com.skillconnect.server.repository.LearningPlanRepository;
import com.skillconnect.server.repository.LearningPlanItemRepository;
import com.skillconnect.server.repository.UserRepository;
<<<<<<< HEAD
import com.skillconnect.server.service.LearningPlanItemService;
=======
>>>>>>> origin/Member02
import com.skillconnect.server.service.LearningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.util.List;
import java.util.Optional;
>>>>>>> origin/Member02

@Log4j2
@Service
@Transactional
public class LearningPlanServiceImpl implements LearningPlanService {

    private final LearningPlanRepository learningPlanRepository;
    private final LearningPlanItemRepository learningPlanItemRepository;
    private final UserRepository userRepository;
<<<<<<< HEAD
    private final LearningPlanItemService itemService;

=======
    
>>>>>>> origin/Member02
    @Autowired
    public LearningPlanServiceImpl(
            LearningPlanRepository learningPlanRepository,
            LearningPlanItemRepository learningPlanItemRepository,
<<<<<<< HEAD
            UserRepository userRepository, LearningPlanItemService itemService) {
        this.learningPlanRepository = learningPlanRepository;
        this.learningPlanItemRepository = learningPlanItemRepository;
        this.userRepository = userRepository;
        this.itemService = itemService;
        log.info("LearningPlanServiceImpl initialized");
    }

    @Override
    public LearningPlan createLearningPlan(LearningPlanDTO dto) {
        log.info("Creating new learning plan for user ID: {}", dto.getUser().getUserId());
        User user = userRepository.findById(dto.getUser().getUserId())
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", dto.getUser().getUserId());
                    return new RuntimeException("User not found with id: " + dto.getUser().getUserId());
                });

        LearningPlan savedPlan = learningPlanRepository.save(dto.DTOToLearningPlan(user));

        for (LearningPlanItem item : dto.DTOToLearningPlanItem(savedPlan)) {
            itemService.createItem(item);
        }

        log.info("Learning plan created successfully with ID: {}", savedPlan.getUser().getUserId());
        return savedPlan;
    }

    @Override
    public LearningPlanDTO findById(int planId) {
        log.debug("Finding learning plan by ID: {}", planId);

        LearningPlan learningPlan = learningPlanRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Learning Plan not found with ID: " + planId));

        List<LearningPlanItem> items = itemService.findItemsByPlanId(planId);
        double status = calculateStatus(items);

        return new LearningPlanDTO().EntityToDTO(learningPlan, items, status);
    }


    @Override
    public List<LearningPlanDTO> findLearningPlansByUserId(int userId) {
        log.debug("Finding learning plans for user ID: {}", userId);

        List<LearningPlan> plans = learningPlanRepository.findByUser_UserId(userId);
        List<LearningPlanDTO> dtoList = new ArrayList<>();

        for (LearningPlan plan : plans) {
            List<LearningPlanItem> items = itemService.findItemsByPlanId(plan.getPlanId());
            double status = calculateStatus(items);
            LearningPlanDTO dto = new LearningPlanDTO().EntityToDTO(plan, items, status);
            dtoList.add(dto);
        }

        log.debug("Found {} learning plans for user ID: {}", dtoList.size(), userId);
        return dtoList;
    }


=======
            UserRepository userRepository) {
        this.learningPlanRepository = learningPlanRepository;
        this.learningPlanItemRepository = learningPlanItemRepository;
        this.userRepository = userRepository;
        log.info("LearningPlanServiceImpl initialized");
    }
    
    @Override
    public LearningPlan createLearningPlan(LearningPlan learningPlan) {
        log.info("Creating new learning plan for user ID: {}", learningPlan.getUser().getUserId());
        User user = userRepository.findById(learningPlan.getUser().getUserId())
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", learningPlan.getUser().getUserId());
                    return new RuntimeException("User not found with id: " + learningPlan.getUser().getUserId());
                });
        
        learningPlan.setUser(user);
        // Note: The @PrePersist will handle setting createdAt and updatedAt
        
        LearningPlan savedPlan = learningPlanRepository.save(learningPlan);
        log.info("Learning plan created successfully with ID: {}", savedPlan.getUser().getUserId());
        return savedPlan;
    }
    
    @Override
    public Optional<LearningPlan> findById(int planId) {
        log.debug("Finding learning plan by ID: {}", planId);
        return learningPlanRepository.findById(planId);
    }
    
    @Override
    public List<LearningPlan> findLearningPlansByUserId(int userId) {
        log.debug("Finding learning plans for user ID: {}", userId);
        List<LearningPlan> plans = learningPlanRepository.findByUser_UserId(userId);
        log.debug("Found {} learning plans for user ID: {}", plans.size(), userId);
        return plans;
    }
    
>>>>>>> origin/Member02
    @Override
    public LearningPlan updateLearningPlan(LearningPlan learningPlan) {
        log.info("Updating learning plan with ID: {}", learningPlan.getPlanId());
        if (!learningPlanRepository.existsById(learningPlan.getPlanId())) {
            log.error("Learning plan not found with ID: {}", learningPlan.getPlanId());
            throw new RuntimeException("Learning plan not found with id: " + learningPlan.getPlanId());
        }
<<<<<<< HEAD

=======
        
>>>>>>> origin/Member02
        learningPlan.setUpdatedAt(LocalDateTime.now());
        LearningPlan updatedPlan = learningPlanRepository.save(learningPlan);
        log.info("Learning plan updated successfully: {}", learningPlan.getPlanId());
        return updatedPlan;
    }
<<<<<<< HEAD

=======
    
>>>>>>> origin/Member02
    @Override
    public void deleteLearningPlan(int planId) {
        log.info("Deleting learning plan with ID: {}", planId);
        learningPlanRepository.deleteById(planId);
        log.info("Learning plan deleted successfully: {}", planId);
    }
<<<<<<< HEAD

=======
    
>>>>>>> origin/Member02
    @Override
    public LearningPlanItem addItemToPlan(LearningPlanItem item, int planId) {
        log.info("Adding item to learning plan ID: {}", planId);
        LearningPlan plan = learningPlanRepository.findById(planId)
                .orElseThrow(() -> {
                    log.error("Learning plan not found with ID: {}", planId);
                    return new RuntimeException("Learning plan not found with id: " + planId);
                });
<<<<<<< HEAD

        item.setLearningPlan(plan);

=======
        
        item.setLearningPlan(plan);
        // Note: The @PrePersist will handle setting createdAt and updatedAt
        
>>>>>>> origin/Member02
        LearningPlanItem savedItem = learningPlanItemRepository.save(item);
        log.info("Item added successfully to plan with ID: {}", planId);
        return savedItem;
    }
<<<<<<< HEAD

    @Override
    public double calculateStatus(List<LearningPlanItem> items) {
        int itemCount = 0;
        int completeCount = 0;
        for (LearningPlanItem item : items) {
            itemCount++;
            if (item.isComplete())
                completeCount++;
        }
        return ((double) completeCount / itemCount) * 100;
    }

=======
    
>>>>>>> origin/Member02
    @Override
    public void removeItemFromPlan(int itemId) {
        log.info("Removing item ID: {} from learning plan", itemId);
        learningPlanItemRepository.deleteById(itemId);
        log.info("Item removed successfully: {}", itemId);
    }
}
