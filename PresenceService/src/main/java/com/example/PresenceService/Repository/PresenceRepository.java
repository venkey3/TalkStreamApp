package com.example.PresenceService.Repository;

import com.example.PresenceService.Entity.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PresenceRepository extends JpaRepository<Presence, Long> {

    
    Optional<Presence> findByUserId(Long userId);
}