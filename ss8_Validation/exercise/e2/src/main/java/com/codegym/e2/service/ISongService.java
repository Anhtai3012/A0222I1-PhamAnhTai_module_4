package com.codegym.e2.service;

import com.codegym.e2.model.Song;
import com.codegym.e2.repository.SongRepository;

import java.util.List;

public interface ISongService  {
    List<Song> findAll();
    void save(Song song);

}
