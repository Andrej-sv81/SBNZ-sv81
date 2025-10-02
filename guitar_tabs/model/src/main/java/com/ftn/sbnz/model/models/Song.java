package com.ftn.sbnz.model.models;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private SkillLevel level;

    @Enumerated(EnumType.STRING)
    private SongGenre genre;

    @Enumerated(EnumType.STRING)
    private LearningGoal goal;

    private String artist;
    private int likes;

    public Song() {
    }

    public Song(Long id, String title, String content, SkillLevel level, SongGenre genre, LearningGoal goal, String artist) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.level = level;
        this.genre = genre;
        this.goal = goal;
        this.artist = artist;
        this.likes = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "id=" + id + '\'' +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", level=" + level +
                ", genre=" + genre +
                ", goal=" + goal +
                '}';
    }
}
