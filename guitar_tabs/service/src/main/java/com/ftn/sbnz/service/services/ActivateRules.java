package com.ftn.sbnz.service.services;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.*;

@Service
public class ActivateRules {

    private final KieContainer kieContainer;
    private final KieSession kSession;
    private List<Song> songs = new ArrayList<Song>();
    
    @Autowired
    public ActivateRules(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
        this.kSession = kieContainer.newKieSession();
    }

    public void fireRules() {
        kSession.insert(new Player("andrej5@gmail.com", "123123", SkillLevel.BEGINNER, SongGenre.ROCK, LearningGoal.RHYTHM, "Am C G"));
        kSession.insert(new Player("markomarkovic@gmail.com", "password", SkillLevel.ADVANCED, SongGenre.NA, LearningGoal.SOLO, "Am A C G D E F F# G# A# B C# D# Fm Gm Cm Dm Em Fm"));
        kSession.insert(new Player("rhythmplayer@gmail.com", "rhythmrules", SkillLevel.NA, SongGenre.NA, LearningGoal.RHYTHM, "*"));


        kSession.insert(new Song(1L, "Tisina", "Am C G Am", SkillLevel.BEGINNER, SongGenre.ROCK, LearningGoal.RHYTHM, "Bajaga"));
        kSession.insert(new Song(2L, "Perfect", "G Em C D D F# Dsus4", SkillLevel.BEGINNER, SongGenre.POP, LearningGoal.RHYTHM, "Ed Sheeran"));
        kSession.insert(new Song(3L, "Let it be", "C G Am F C G F C", SkillLevel.INTERMEDIATE, SongGenre.ROCK, LearningGoal.RHYTHM, "Bajaga"));
        kSession.insert(new Song(4L, "Hotel California", "Bm F# A E G D Em F#", SkillLevel.ADVANCED, SongGenre.ROCK, LearningGoal.SOLO, "Eagles"));
        kSession.getAgenda().getAgendaGroup("filter").setFocus();
        kSession.fireAllRules();
    }

    public void getAll(String email) {
        QueryResults results = kSession.getQueryResults("songsForPlayerByEmail", email);
        for (QueryResultsRow row : results) {
            Song s = (Song) row.get("$song");
            System.out.println("Song Title: " + s.getTitle());
        }
    }

    public void learnSong(String email, Long songId){
        QueryResults results = kSession.getQueryResults("canPlayerLearnSong", email, songId);
        
        if(results.size() == 0) {
            System.out.println("Song is too difficult for player: " + email);
            return;
        }else{
            for (QueryResultsRow row : results) {
                Player p = (Player) row.get("$player");
                Song s = (Song) row.get("$song");
                LearningPlan lp = new LearningPlan(p, s);
                System.out.println("Created learning plan for player " + lp.getPlayer().getEmail() + " and song " + lp.getSong().getTitle());
                lp.getMissingChords();
                kSession.insert(lp);
                kSession.getAgenda().getAgendaGroup("learning").setFocus();
                kSession.fireAllRules();
            }
        }
    }

    public void reccomendSongs(){
        this.songs.add(new Song(1L, "Tisina", "Am C G Am", SkillLevel.BEGINNER, SongGenre.ROCK, LearningGoal.RHYTHM, "Bajaga"));
        this.songs.add(new Song(2L, "Perfect", "G Em C D D F# Dsus4", SkillLevel.BEGINNER, SongGenre.POP, LearningGoal.RHYTHM, "Ed Sheeran"));
        this.songs.add(new Song(3L, "Let it be", "C G Am F C G F C", SkillLevel.INTERMEDIATE, SongGenre.ROCK, LearningGoal.RHYTHM, "Beatles"));
        this.songs.add(new Song(4L, "Hotel California", "Bm F# A E G D Em F#", SkillLevel.ADVANCED, SongGenre.ROCK, LearningGoal.SOLO, "Eagles"));
        this.songs.add(new Song(5L, "Bohemian Rhapsody", "Bb6 Cm7 F7 Bb6 Gm7 Cm7 F7 Bb6", SkillLevel.ADVANCED, SongGenre.ROCK, LearningGoal.SOLO, "Queen"));
        this.songs.add(new Song(6L, "Imagine", "C Cmaj7 F Am Dm G", SkillLevel.BEGINNER, SongGenre.POP, LearningGoal.RHYTHM, "John Lennon"));
        this.songs.add(new Song(7L, "Smells Like Teen Spirit", "F Bb Ab Db", SkillLevel.INTERMEDIATE, SongGenre.ROCK, LearningGoal.RHYTHM, "Nirvana"));
        this.songs.add(new Song(8L, "Billie Jean", "F#m G#m A B", SkillLevel.INTERMEDIATE, SongGenre.POP, LearningGoal.RHYTHM, "Michael Jackson"));
        this.songs.add(new Song(9L, "Wonderwall", "Em G D   A7sus4", SkillLevel.BEGINNER, SongGenre.ROCK, LearningGoal.RHYTHM, "Oasis"));
        this.songs.add(new Song(10L, "Sweet Child O' Mine", "   D C G D", SkillLevel.ADVANCED, SongGenre.ROCK, LearningGoal.SOLO, "Guns N' Roses"));
        this.songs.get(6).setLikes(61);
        this.songs.get(8).setLikes(60);

        for(Song s : this.songs){
            kSession.insert(s);
        }

        Player p = new Player("andrej5@gmail.com", "123123", SkillLevel.BEGINNER, SongGenre.ROCK, LearningGoal.RHYTHM, "Am C G");
        p.addLikedSong(1L);
        kSession.insert(p);

        for(Song s : this.songs){
            if(!p.getLikedSongs().contains(s.getId())){
                kSession.insert(new SongScore(s, p, 0));
            }
        }

        kSession.getAgenda().getAgendaGroup("recommend").setFocus();
        kSession.fireAllRules();
       
    }











    
    // public void reloadRules() {
    //     KieSession kieSession = kieContainer.newKieSession();

    //     // Example data for generating rules
    //     List<Map<String, Object>> data = new ArrayList<>();
    //     data.add(Map.of("matchAttribute", "level", "matchValue", "SkillLevel.BEGINNER"));
    //     data.add(Map.of("matchAttribute", "level", "matchValue", "SkillLevel.INTERMEDIATE"));
    //     data.add(Map.of("matchAttribute", "level", "matchValue", "SkillLevel.ADVANCED"));
    //     data.add(Map.of("matchAttribute", "genre", "matchValue", "SongGenre.ROCK"));
    //     data.add(Map.of("matchAttribute", "goal", "matchValue", "LearningGoal.RHYTHM"));

    //     // Load and compile template with data
    //     InputStream templateStream = getClass().getResourceAsStream("/rules/rule-template.drt");
    //     ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
    //     // String drl = converter.compile(templateStream, data);

    //     Object kieServices;
    //     // Add to knowledge base and build
    //     // KieFileSystem kfs = kieServices.newKieFileSystem();
    //     // kfs.write("src/main/resources/rules.drl", drl);
    //     // kieServices.newKieBuilder(kfs).buildAll();

    //     // Continue as usual...
    // }
}
