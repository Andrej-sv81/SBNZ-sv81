package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {}