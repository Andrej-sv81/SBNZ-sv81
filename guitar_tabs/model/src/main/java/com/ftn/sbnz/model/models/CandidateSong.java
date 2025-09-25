package com.ftn.sbnz.model.models;

public class CandidateSong {
    private Player player;
    private Song song;

    public CandidateSong(Player player, Song song) {
        this.player = player;
        this.song = song;
    }

    public Player getPlayer() {
        return player;
    }

    public Song getSong() {
        return song;
    }
}