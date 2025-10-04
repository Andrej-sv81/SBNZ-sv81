package com.ftn.sbnz.model.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private SkillLevel level;

    @Enumerated(EnumType.STRING)
    private SongGenre genre;

    @Enumerated(EnumType.STRING)
    private LearningGoal goal;

    private String chords;
    private int songCounter;

    @ElementCollection
    private Set<Long> songs = new HashSet<>();

    @ElementCollection
    private Set<Long> likedSongs = new HashSet<>();

    @ElementCollection
    private Set<Long> recommendedSongs = new HashSet<>();

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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Long> getLikedSongs() {
        return likedSongs;
    }

    public void addLikedSong(Long id) {
        this.likedSongs.add(id);
    }

    public void removeLikedSong(Long id) {
        this.likedSongs.remove(id);
    }

    public Set<Long> getRecommendedSongs() {
        return recommendedSongs;
    }

    public void addRecommendedSong(Long id) {
        this.recommendedSongs.add(id);
    }

    public void clearRecommendedSongs() {
        this.recommendedSongs.clear();
    }

    public void clearSongs() {
        this.songs.clear();
    }
    
    public void clearLikedSongs() {
        this.likedSongs.clear();
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
