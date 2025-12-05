package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.LearningGoal;
import com.ftn.sbnz.model.models.Player;
import com.ftn.sbnz.model.models.SkillLevel;
import com.ftn.sbnz.model.models.SongGenre;
import com.ftn.sbnz.service.dto.UserDataDTO;
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

    public Player findByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    public Player createAndSavePlayer(String email, String password, String level, String genre, String goal) {
        Player newPlayer = new Player();
        newPlayer.setEmail(email);
        newPlayer.setPassword(password);
        newPlayer.setLevel(level != null ? SkillLevel.valueOf(level) : SkillLevel.NA);
        newPlayer.setGenre(genre != null ? SongGenre.valueOf(genre) : SongGenre.NA);
        newPlayer.setGoal(goal != null ? LearningGoal.valueOf(goal) : LearningGoal.NA);
        return playerRepository.save(newPlayer);
    }

    public UserDataDTO getUserDataDTO(String email) {
        Player player = playerRepository.findByEmail(email);
        if (player == null) return null;
        UserDataDTO dto = new UserDataDTO();
        dto.email = player.getEmail();
        dto.level = player.getLevel().toString();
        dto.genre = player.getGenre().toString();
        dto.goal = player.getGoal().toString();
        dto.songNumber = player.getSongCounter();
        dto.chords = player.getChords();
        return dto;
    }

    public void save(Player player) {
        playerRepository.save(player);
    }

    public Player updateUser(String email, String level, String genre, String goal, String chords) {
        Player player = playerRepository.findByEmail(email);
        if (player == null) return null;
        player.setLevel(level != null ? SkillLevel.valueOf(level) : SkillLevel.NA);
        player.setGenre(genre != null ? SongGenre.valueOf(genre) : SongGenre.NA);
        player.setGoal(goal != null ? LearningGoal.valueOf(goal) : LearningGoal.NA);
        player.setChords(chords);
        return playerRepository.save(player);
    }
    
}