package com.ftn.sbnz.model.models;

public class SongScore {
    private Song song;
    private Player player;
    private int points;

    public SongScore(Song song, Player player, int points) {
        this.song = song;
        this.player = player;
        this.points = points;
    }

    public void addPoints(int p) { this.points += p; }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}