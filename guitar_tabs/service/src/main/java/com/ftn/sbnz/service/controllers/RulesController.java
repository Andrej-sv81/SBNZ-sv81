package com.ftn.sbnz.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.models.LearningGoal;
import com.ftn.sbnz.model.models.Player;
import com.ftn.sbnz.model.models.SkillLevel;
import com.ftn.sbnz.model.models.SongGenre;
import com.ftn.sbnz.service.dto.UserLoginDTO;
import com.ftn.sbnz.service.dto.UserRegisterDTO;
import com.ftn.sbnz.service.services.ActivateRules;
import com.ftn.sbnz.service.services.PlayerService;

@RestController
@RequestMapping("/api/rules")
public class RulesController {

    @Autowired
    private ActivateRules service;
    @Autowired
    private PlayerService playerService;

    @GetMapping()
    public void fireAllRules() {
        // service.fireRules();
        service.reccomendSongs();
    }

    @GetMapping("/all/{email}")
    public void getAllSongs(@PathVariable String email) {
        service.getAll(email);
    }

    @GetMapping("/learn/{email}/{songId}")
    public void learnSong(@PathVariable String email, @PathVariable Long songId) {
        service.learnSong(email, songId);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginDTO> login(@RequestBody UserLoginDTO dto) {
        Player player = playerService.findByEmail(dto.email);
        if (player != null && player.getPassword().equals(dto.password)) {
            return new ResponseEntity<UserLoginDTO>(new UserLoginDTO(player.getEmail(), player.getPassword()), HttpStatus.OK);
        }
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterDTO> register(@RequestBody UserRegisterDTO dto) {
        Player existing = playerService.findByEmail(dto.email);
        if (existing != null) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        Player newPlayer = new Player();
        newPlayer.setEmail(dto.email);
        newPlayer.setPassword(dto.password);
        newPlayer.setLevel(dto.level != null ? SkillLevel.valueOf(dto.level) : SkillLevel.NA);
        newPlayer.setGenre(dto.genre != null ? SongGenre.valueOf(dto.genre) : SongGenre.NA);
        newPlayer.setGoal(dto.goal != null ? LearningGoal.valueOf(dto.goal) : LearningGoal.NA);
        playerService.savePlayer(newPlayer);

        return new ResponseEntity<>(new UserRegisterDTO(newPlayer.getEmail(),
                                                        newPlayer.getPassword(),
                                                        newPlayer.getLevel().toString(),
                                                        newPlayer.getGenre().toString(),
                                                        newPlayer.getGoal().toString()), HttpStatus.CREATED);
    }
}
