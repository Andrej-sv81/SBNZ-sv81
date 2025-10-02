package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByEmail(String email);
}