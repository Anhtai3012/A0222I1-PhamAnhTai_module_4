package com.codegym.e2.repository;

import com.codegym.e2.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SongRepository extends JpaRepository<Song,Integer> {
}
