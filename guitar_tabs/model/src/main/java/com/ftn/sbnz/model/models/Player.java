package com.ftn.sbnz.model.models;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String email;
    private String password;
    private SkillLevel level;
    private SongGenre genre;
    private LearningGoal goal;
    private String chords;
    private int songCounter;
    private Set<Long> songs;

    public Player() {
    }

    public Player(String email, String password, SkillLevel level, SongGenre genre, LearningGoal goal, String chords) {
        this.email = email;
        this.password = password;
        this.level = level;
        this.genre = genre;
        this.goal = goal;
        this.chords = chords;
        this.songCounter = 0;
        this.songs = new HashSet<Long>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    public SongGenre getGenre() {
        return genre;
    }

    public void setGenre(SongGenre genre) {
        this.genre = genre;
    }

    public LearningGoal getGoal() {
        return goal;
    }

    public void setGoal(LearningGoal goal) {
        this.goal = goal;
    }

    public String getChords() {
        return chords;
    }
    
    public void setChords(String chords) {
        this.chords = chords;
    }

    public int getSongCounter() {
        return songCounter;
    }
    
    public void setSongCounter(int songCounter) {
        this.songCounter = songCounter;
    }

    public Set<Long> getSongs() {
        return songs;
    }

    public void addSong(Long id) {
        this.songs.add(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                ", genre=" + genre +
                ", goal=" + goal +
                '}';
    }
}
