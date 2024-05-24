package com.ftn.sbnz.service.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.LearningGoal;
import com.ftn.sbnz.model.models.Player;
import com.ftn.sbnz.model.models.SkillLevel;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.SongGenre;

@Service
public class ActivateRules {
    private final KieContainer kieContainer;

    @Autowired
    public ActivateRules(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public void fireRules() {
        KieSession kSession = kieContainer.newKieSession();

        kSession.insert(
                new Player("andrej5@gmail.com", "123123", SkillLevel.BEGINNER, SongGenre.ROCK, LearningGoal.RHYTHM));

        kSession.insert(new Song(1L, "Tisina", "Am C G Am", SkillLevel.BEGINNER, SongGenre.ROCK, LearningGoal.RHYTHM));
        kSession.insert(new Song(2L, "Perfect", "G Em C D D\\F# Dsus4", SkillLevel.BEGINNER, SongGenre.POP,
                LearningGoal.RHYTHM));

        kSession.fireAllRules();
    }

    public void reloadRules() {
        KieSession kieSession = kieContainer.newKieSession();

        // Example data for generating rules
        List<Map<String, Object>> data = new ArrayList<>();
        data.add(Map.of("matchAttribute", "level", "matchValue", "SkillLevel.BEGINNER"));
        data.add(Map.of("matchAttribute", "level", "matchValue", "SkillLevel.INTERMEDIATE"));
        data.add(Map.of("matchAttribute", "level", "matchValue", "SkillLevel.ADVANCED"));
        data.add(Map.of("matchAttribute", "genre", "matchValue", "SongGenre.ROCK"));
        data.add(Map.of("matchAttribute", "goal", "matchValue", "LearningGoal.RHYTHM"));

        // Load and compile template with data
        InputStream templateStream = getClass().getResourceAsStream("/rules/rule-template.drt");
        ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
        // String drl = converter.compile(templateStream, data);

        Object kieServices;
        // Add to knowledge base and build
        // KieFileSystem kfs = kieServices.newKieFileSystem();
        // kfs.write("src/main/resources/rules.drl", drl);
        // kieServices.newKieBuilder(kfs).buildAll();

        // Continue as usual...
    }
}
