package com.ftn.sbnz.model.models;

import java.util.HashSet;
import java.util.Set;

public class LearningPlan {
    private Player player;
    private Song song;
    private Set<String> chordsToLearn;
    
    public LearningPlan(Player player, Song song) {
        this.player = player;
        this.song = song;
        this.chordsToLearn = new HashSet<String>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Set<String> getChordsToLearn() {
        return chordsToLearn;
    }

    public void addChordToLearn(String chord) {
        this.chordsToLearn.add(chord);
    }

    public void setChordsToLearn(Set<String> chordsToLearn) {
        this.chordsToLearn = chordsToLearn;
    }

    public void getMissingChords(){
        Set<String> playerChords = new HashSet<String>();
        for(String chord : player.getChords().split(" ")) {
            playerChords.add(chord);
        }

        if (playerChords.contains("*")) {
            this.setChordsToLearn(playerChords);
        }else{
            Set<String> songChords = new HashSet<String>();
            for(String chord : song.getContent().split(" ")) {
                songChords.add(chord);
            }
            songChords.removeAll(playerChords);
            this.setChordsToLearn(songChords);
        }
    }

}
