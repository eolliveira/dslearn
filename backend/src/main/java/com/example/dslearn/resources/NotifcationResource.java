package com.example.dslearn.resources;

import com.example.dslearn.dto.NotificationDTO;
import com.example.dslearn.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotifcationResource {
    @Autowired
    private NotificationService service;

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> notificationsForCurrentUser(
            @RequestParam(value = "unreadOnly", defaultValue = "0") Boolean unreadOnly,
            Pageable pageable) {
        Page<NotificationDTO> dto = service.notificationsForCurrentUser(unreadOnly, pageable);
        return ResponseEntity.ok().body(dto);
    }
}
