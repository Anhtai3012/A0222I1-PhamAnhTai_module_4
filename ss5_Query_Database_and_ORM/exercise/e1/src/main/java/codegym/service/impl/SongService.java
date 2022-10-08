package codegym.service.impl;

import codegym.model.Song;
import codegym.service.BaseRepository;
import codegym.service.ISongService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
@Service
public class SongService implements ISongService {
  //  private final String SELECT_ALL= "select s from song s";
   private static List<Song> songList = new ArrayList<>();
    @Override
    public List<Song> findAll() {
        List<Song> songList = BaseRepository.entityManager.createQuery("select s from song s",Song.class).getResultList();
        return songList;
    }

    @Override
    public Song findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }
}
