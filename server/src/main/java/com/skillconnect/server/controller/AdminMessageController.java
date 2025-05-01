package com.skillconnect.server.controller;

import com.skillconnect.server.model.AdminMessage;
import com.skillconnect.server.service.AdminMessageService;
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
@RequestMapping("/api/admin-messages")
<<<<<<< HEAD
<<<<<<< HEAD
=======
@AllArgsConstructor(onConstructor = @__(@Autowired))
>>>>>>> origin/Member02
=======
@AllArgsConstructor(onConstructor = @__(@Autowired))
>>>>>>> origin/Member04
public class AdminMessageController {

    private final AdminMessageService adminMessageService;

<<<<<<< HEAD
<<<<<<< HEAD
    @Autowired
    public AdminMessageController(AdminMessageService adminMessageService) {
        this.adminMessageService = adminMessageService;
    }

=======
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    @PostMapping
    public ResponseEntity<AdminMessage> createMessage(@RequestBody AdminMessage message) {
        AdminMessage created = adminMessageService.createMessage(message);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminMessage> getMessageById(@PathVariable int id) {
<<<<<<< HEAD
<<<<<<< HEAD
        return adminMessageService.findById(id)
=======
=======
>>>>>>> origin/Member04
        AdminMessage message = new AdminMessage();
        message.setMessageId(id);

        return adminMessageService.findById(message)
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AdminMessage>> getAllMessages() {
        return ResponseEntity.ok(adminMessageService.findAllMessages());
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<AdminMessage>> getMessagesByAdminId(@PathVariable int adminId) {
<<<<<<< HEAD
<<<<<<< HEAD

        return ResponseEntity.ok(adminMessageService.findMessagesByAdminId(adminId));
=======
=======
>>>>>>> origin/Member04
        AdminMessage admin = new AdminMessage();
        admin.getAdmin().setUserId(adminId);

        return ResponseEntity.ok(adminMessageService.findMessagesByAdminId(admin));
<<<<<<< HEAD
>>>>>>> origin/Member02
=======
>>>>>>> origin/Member04
    }

    @PutMapping
    public ResponseEntity<AdminMessage> updateMessage(@RequestBody AdminMessage adminMessage) {
        return ResponseEntity.ok(adminMessageService.updateMessage(adminMessage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id) {
        adminMessageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}

