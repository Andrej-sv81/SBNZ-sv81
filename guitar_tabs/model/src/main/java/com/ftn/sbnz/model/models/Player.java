package com.ftn.sbnz.model.models;

import java.util.List;

import org.kie.api.definition.type.Position;

public class Player {
    @Position(0)
    private String email;
    @Position(1)
    private String password;
    @Position(2)
    private SkillLevel level;
    @Position(3)
    private SongGenre genre;
    @Position(4)
    private LearningGoal goal;
    @Position(5)
    private List<Long> songs;

    public Player() {
    }

    // Constructor with all fields
    public Player(String email, String password, SkillLevel level, SongGenre genre, LearningGoal goal) {
        this.email = email;
        this.password = password;
        this.level = level;
        this.genre = genre;
        this.goal = goal;
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

    public List<Long> getSongs() {
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
