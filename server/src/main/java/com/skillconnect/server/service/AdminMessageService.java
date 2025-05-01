package com.skillconnect.server.service;

import com.skillconnect.server.model.AdminMessage;

import java.util.List;
import java.util.Optional;

public interface AdminMessageService {
    
    AdminMessage createMessage(AdminMessage message);
    
<<<<<<< HEAD
<<<<<<< HEAD
    Optional<AdminMessage> findById(int id);
    
    List<AdminMessage> findAllMessages();
    
    List<AdminMessage> findMessagesByAdminId(int id);
=======
=======
>>>>>>> origin/Member04
    Optional<AdminMessage> findById(AdminMessage message);
    
    List<AdminMessage> findAllMessages();
    
    List<AdminMessage> findMessagesByAdminId(AdminMessage message);
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    
    AdminMessage updateMessage(AdminMessage adminMessage);
    
    void deleteMessage(int messageId);
}
