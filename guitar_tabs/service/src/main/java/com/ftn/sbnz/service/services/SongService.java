package com.ftn.sbnz.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.LearningGoal;
import com.ftn.sbnz.model.models.SkillLevel;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.SongGenre;
import com.ftn.sbnz.service.repositories.SongRepository;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public void addSong(Song song){
        songRepository.save(song);
    }

    public Song createAndAddSong(String title, String content, String level, String genre, String goal, String artist) {
        Song song = new Song();
        song.setTitle(title);
        song.setContent(content);
        song.setLevel(level != null ? SkillLevel.valueOf(level) : SkillLevel.NA);
        song.setGenre(genre != null ? SongGenre.valueOf(genre) : SongGenre.NA);
        song.setGoal(goal != null ? LearningGoal.valueOf(goal) : LearningGoal.NA);
        song.setArtist(artist);
        song.setLikes(0);
        return songRepository.save(song);
    }
}
