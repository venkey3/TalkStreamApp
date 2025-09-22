package com.example.PresenceService.Service;

import com.example.PresenceService.Entity.Presence;
import com.example.PresenceService.Repository.PresenceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PresenceService {

    private final PresenceRepository presenceRepository;

    public PresenceService(PresenceRepository presenceRepository) {
        this.presenceRepository = presenceRepository;
    }

   
    public Presence setUserOnline(Long userId) {
        Optional<Presence> presence = presenceRepository.findByUserId(userId);
        if (presence.isPresent()) {
            Presence p = presence.get();
            p.setOnline(true);
            return presenceRepository.save(p);
        } else {
            return presenceRepository.save(new Presence(userId, true));
        }
    }

    
    public Presence setUserOffline(Long userId) {
        Optional<Presence> presence = presenceRepository.findByUserId(userId);
        if (presence.isPresent()) {
            Presence p = presence.get();
            p.setOnline(false);
            return presenceRepository.save(p);
        } else {
            return presenceRepository.save(new Presence(userId, false));
        }
    }

    
    public boolean isUserOnline(Long userId) {
        return presenceRepository.findByUserId(userId)
                .map(Presence::isOnline)
                .orElse(false);
    }
}
