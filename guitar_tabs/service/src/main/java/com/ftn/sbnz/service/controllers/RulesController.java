package com.ftn.sbnz.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.models.Player;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.service.dto.SongAddDTO;
import com.ftn.sbnz.service.dto.SongReturnDTO;
import com.ftn.sbnz.service.dto.UserDataDTO;
import com.ftn.sbnz.service.dto.UserLoginDTO;
import com.ftn.sbnz.service.dto.UserRegisterDTO;
import com.ftn.sbnz.service.services.ActivateRules;
import com.ftn.sbnz.service.services.PlayerService;
import com.ftn.sbnz.service.services.SongService;

@RestController
@RequestMapping("/api/rules")
public class RulesController {

    @Autowired
    private ActivateRules service;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private SongService songService;

    @GetMapping()
    public void fireAllRules() {
        // service.fireRules();
        service.reccomendSongs();
    }

    @GetMapping("/all/{email}")
    public ResponseEntity<?> getAllSongs(@PathVariable String email) {
        Player player = playerService.findByEmail(email);
        if(player != null){
            List<SongReturnDTO> songs = service.getSongs(player);
            return new ResponseEntity<>(songs, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<UserLoginDTO> register(@RequestBody UserRegisterDTO dto) {
        Player existing = playerService.findByEmail(dto.email);
        if (existing != null) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        Player newPlayer = playerService.createAndSavePlayer(dto.email, dto.password, dto.level, dto.genre, dto.goal);
        return new ResponseEntity<>(new UserLoginDTO(newPlayer.getEmail(), newPlayer.getPassword()), HttpStatus.CREATED);
    }

    @GetMapping("/user-data")
    public ResponseEntity<UserDataDTO> getUserData(String email) {
        UserDataDTO dto = playerService.getUserDataDTO(email);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-song")
    public ResponseEntity<?> addSong(@RequestBody SongAddDTO dto) {
        Song song = songService.createAndAddSong(dto.title, dto.content, dto.level, dto.genre, dto.goal, dto.artist);
        return new ResponseEntity<>(song, HttpStatus.CREATED);
    }
}
