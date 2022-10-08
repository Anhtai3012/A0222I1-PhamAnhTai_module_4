package codegym.service;

import codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);
    void delete(int id);
    void save(Song song);
}
