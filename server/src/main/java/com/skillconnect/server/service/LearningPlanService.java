package com.skillconnect.server.service;

<<<<<<< HEAD
<<<<<<< HEAD
import com.skillconnect.server.dto.LearningPlanDTO;
=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
import com.skillconnect.server.model.LearningPlan;
import com.skillconnect.server.model.LearningPlanItem;

import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD

public interface LearningPlanService {
    
    LearningPlan createLearningPlan(LearningPlanDTO dto);
    
    LearningPlanDTO findById(int planId);
    
    List<LearningPlanDTO> findLearningPlansByUserId(int userId);
=======
=======
>>>>>>> origin/Member04
import java.util.Optional;

public interface LearningPlanService {
    
    LearningPlan createLearningPlan(LearningPlan learningPlan);
    
    Optional<LearningPlan> findById(int planId);
    
    List<LearningPlan> findLearningPlansByUserId(int userId);
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    
    LearningPlan updateLearningPlan(LearningPlan learningPlan);
    
    void deleteLearningPlan(int planId);

    void removeItemFromPlan(int itemId);

    LearningPlanItem addItemToPlan(LearningPlanItem item, int planId);
<<<<<<< HEAD
<<<<<<< HEAD

    double calculateStatus(List<LearningPlanItem> items);
=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
}
