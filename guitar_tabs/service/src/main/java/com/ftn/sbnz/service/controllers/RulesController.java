package com.ftn.sbnz.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ftn.sbnz.service.services.ActivateRules;

@RestController
@RequestMapping("/rules")
public class RulesController {
    private ActivateRules service;

    @Autowired
    public RulesController(ActivateRules service) {
        this.service = service;
    }

    @GetMapping("")
    public void fireAllRules() {
        service.fireRules();
    }
}
