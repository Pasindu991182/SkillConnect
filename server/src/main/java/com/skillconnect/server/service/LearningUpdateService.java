package com.skillconnect.server.service;

<<<<<<< HEAD
import com.skillconnect.server.model.LearningUpdate;
import com.skillconnect.server.model.User;
=======
import com.skillconnect.server.model.LearningPlan;
import com.skillconnect.server.model.LearningUpdate;
import com.skillconnect.server.model.UpdateTemplate;
>>>>>>> origin/Member02

import java.util.List;
import java.util.Optional;

public interface LearningUpdateService {
<<<<<<< HEAD
    
    LearningUpdate saveLearningUpdate(LearningUpdate learningUpdate);
    
    Optional<LearningUpdate> findById(Long updateId);
    
    List<LearningUpdate> findLearningUpdatesByUser(User user);
    
    List<LearningUpdate> findLearningUpdatesByUserId(Long userId);
    
    LearningUpdate updateLearningUpdate(LearningUpdate learningUpdate);
    
    void deleteLearningUpdate(Long updateId);
    
    boolean isUpdateOwner(Long updateId, Long userId);
=======

    LearningUpdate createUpdateFromTemplate(UpdateTemplate template, LearningPlan plan);

    LearningUpdate createUpdate(LearningUpdate update, int planId);
    
    Optional<LearningUpdate> findById(int updateId);
    
    List<LearningUpdate> findUpdatesByUserId(int userId);
    
    LearningUpdate updateLearningUpdate(LearningUpdate learningUpdate);
    
    void deleteUpdate(int updateId);
>>>>>>> origin/Member02
}
