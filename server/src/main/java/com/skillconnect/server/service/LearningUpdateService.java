package com.skillconnect.server.service;

<<<<<<< HEAD
<<<<<<< HEAD
import com.skillconnect.server.model.LearningUpdate;
import com.skillconnect.server.model.User;
=======
import com.skillconnect.server.model.LearningPlan;
import com.skillconnect.server.model.LearningUpdate;
import com.skillconnect.server.model.UpdateTemplate;
>>>>>>> origin/Member02
=======
import com.skillconnect.server.model.LearningPlan;
import com.skillconnect.server.model.LearningUpdate;
import com.skillconnect.server.model.UpdateTemplate;
>>>>>>> origin/Member04

import java.util.List;
import java.util.Optional;

public interface LearningUpdateService {
<<<<<<< HEAD
<<<<<<< HEAD
    
    LearningUpdate saveLearningUpdate(LearningUpdate learningUpdate);
    
    Optional<LearningUpdate> findById(Long updateId);
    
    List<LearningUpdate> findLearningUpdatesByUser(User user);
    
    List<LearningUpdate> findLearningUpdatesByUserId(Long userId);
    
    LearningUpdate updateLearningUpdate(LearningUpdate learningUpdate);
    
    void deleteLearningUpdate(Long updateId);
    
    boolean isUpdateOwner(Long updateId, Long userId);
=======
=======
>>>>>>> origin/Member04

    LearningUpdate createUpdateFromTemplate(UpdateTemplate template, LearningPlan plan);

    LearningUpdate createUpdate(LearningUpdate update, int planId);
    
    Optional<LearningUpdate> findById(int updateId);
    
    List<LearningUpdate> findUpdatesByUserId(int userId);
    
    LearningUpdate updateLearningUpdate(LearningUpdate learningUpdate);
    
    void deleteUpdate(int updateId);
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
}
