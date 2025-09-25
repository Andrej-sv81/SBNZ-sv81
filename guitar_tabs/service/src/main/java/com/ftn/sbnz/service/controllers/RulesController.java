package com.ftn.sbnz.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ftn.sbnz.service.services.ActivateRules;

@RestController
@RequestMapping("/rules")
public class RulesController {
    @Autowired
    private ActivateRules service;

    @GetMapping()
    public void fireAllRules() {
        service.fireRules();
    }

    @GetMapping("/all/{email}")
    public void getAllSongs(@PathVariable String email) {
        service.getAll(email);
    }

    @GetMapping("/learn/{email}/{songId}")
    public void learnSong(@PathVariable String email, @PathVariable Long songId) {
        service.learnSong(email, songId);
    }
}
