package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Player;
import com.ftn.sbnz.service.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }
}