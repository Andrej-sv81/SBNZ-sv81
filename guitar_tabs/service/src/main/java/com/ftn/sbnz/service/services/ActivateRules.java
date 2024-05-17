package com.ftn.sbnz.service.services;

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
}
