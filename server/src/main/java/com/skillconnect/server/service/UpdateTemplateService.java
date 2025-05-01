package com.skillconnect.server.service;

import com.skillconnect.server.model.UpdateTemplate;
<<<<<<< HEAD
import com.skillconnect.server.model.User;
=======
>>>>>>> origin/Member02

import java.util.List;
import java.util.Optional;

public interface UpdateTemplateService {
<<<<<<< HEAD
    
    UpdateTemplate saveUpdateTemplate(UpdateTemplate updateTemplate);
    
    Optional<UpdateTemplate> findById(Long templateId);
    
    List<UpdateTemplate> findAllUpdateTemplates();
    
    List<UpdateTemplate> findUpdateTemplatesByUser(User user);
    
    UpdateTemplate updateUpdateTemplate(UpdateTemplate updateTemplate);
    
    void deleteUpdateTemplate(Long templateId);
=======

    UpdateTemplate createTemplate(UpdateTemplate template);

    List<UpdateTemplate> findAllTemplates();
    
    Optional<UpdateTemplate> findById(int templateId);

    UpdateTemplate updateTemplate(UpdateTemplate template);

    void deleteTemplate(int templateId);
>>>>>>> origin/Member02
}
