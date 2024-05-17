package com.ftn.sbnz.model.models;

import org.kie.api.definition.type.Position;

public class Song {
    @Position(0)
    private Long id;
    @Position(1)
    private String title;
    @Position(2)
    private String content;
    @Position(3)
    private SkillLevel level;
    @Position(4)
    private SongGenre genre;
    @Position(5)
    private LearningGoal goal;

    public Song() {
    }

    public Song(Long id, String title, String content, SkillLevel level, SongGenre genre, LearningGoal goal) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.level = level;
        this.genre = genre;
        this.goal = goal;
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
