package com.skillconnect.server.service;

<<<<<<< HEAD
import com.skillconnect.server.dto.LearningPlanDTO;
=======
>>>>>>> origin/Member02
import com.skillconnect.server.model.LearningPlan;
import com.skillconnect.server.model.LearningPlanItem;

import java.util.List;
<<<<<<< HEAD

public interface LearningPlanService {
    
    LearningPlan createLearningPlan(LearningPlanDTO dto);
    
    LearningPlanDTO findById(int planId);
    
    List<LearningPlanDTO> findLearningPlansByUserId(int userId);
=======
import java.util.Optional;

public interface LearningPlanService {
    
    LearningPlan createLearningPlan(LearningPlan learningPlan);
    
    Optional<LearningPlan> findById(int planId);
    
    List<LearningPlan> findLearningPlansByUserId(int userId);
>>>>>>> origin/Member02
    
    LearningPlan updateLearningPlan(LearningPlan learningPlan);
    
    void deleteLearningPlan(int planId);

    void removeItemFromPlan(int itemId);

    LearningPlanItem addItemToPlan(LearningPlanItem item, int planId);
<<<<<<< HEAD

    double calculateStatus(List<LearningPlanItem> items);
=======
>>>>>>> origin/Member02
}
