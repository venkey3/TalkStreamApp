package com.example.PresenceService.Controller;

import com.example.PresenceService.Entity.Presence;
import com.example.PresenceService.Service.PresenceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/presence")
public class PresenceController {

    private final PresenceService presenceService;

    public PresenceController(PresenceService presenceService) {
        this.presenceService = presenceService;
    }

    @PostMapping("/{userId}/online")
    public Presence setUserOnline(@PathVariable Long userId) {
        return presenceService.setUserOnline(userId);
    }

    @PostMapping("/{userId}/offline")
    public Presence setUserOffline(@PathVariable Long userId) {
        return presenceService.setUserOffline(userId);
    }

    @GetMapping("/{userId}")
    public boolean isUserOnline(@PathVariable Long userId) {
        return presenceService.isUserOnline(userId);
    }
}
