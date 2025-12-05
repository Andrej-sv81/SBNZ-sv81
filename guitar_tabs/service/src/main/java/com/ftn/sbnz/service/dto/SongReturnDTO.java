package com.ftn.sbnz.service.dto;

import java.util.ArrayList;
import java.util.List;

import com.ftn.sbnz.model.models.Song;

public class SongReturnDTO {
    public Long id;
    public String title;
    public String content;
    public String level;
    public String genre;
    public String goal;
    public String artist;
    public int likes;

    public SongReturnDTO(Long id, String title, String content, String level, String genre, String goal, String artist, int likes) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.level = level;
        this.genre = genre;
        this.goal = goal;
        this.artist = artist;
        this.likes = likes;
    }

    public SongReturnDTO() {
    }

    public static List<SongReturnDTO> convertFromSongs(List<Song> songs) {
        List<SongReturnDTO> dtos = new ArrayList<>();
        for (Song song : songs) {
            dtos.add(new SongReturnDTO(song.getId(),song.getTitle(), song.getContent(), song.getLevel().toString(), song.getGenre().toString(), song.getGoal().toString(), song.getArtist(), song.getLikes()));
        }
        return dtos;
    }
}