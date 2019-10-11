package audio.daoImpl;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import audio.HibernateSessionFactory;
import audio.dao.SongDao;
import audio.entities.SongEntity;

/**
 * Created by Elvira on 11.10.2019.
 */
@Repository
public class SongDaoImpl implements SongDao {

  @Override
  public void addSong(SongEntity song) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.persist(song);
    session.getTransaction().commit();
  }

  @Override
  public void updateSong(SongEntity song) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.merge(song);
    session.getTransaction().commit();
  }

  @Override
  public SongEntity getSongById(long idSong) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    return (SongEntity) session.load(SongEntity.class, idSong);
  }

  @Override
  public List listSongs() {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    return session.createQuery("from SongEntity ").list();
  }

  @Override
  public void deleteSong(long idSong) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    SongEntity songEntity = (SongEntity) session.load(SongEntity.class, idSong);
    if (songEntity != null) {
      session.beginTransaction();
      session.delete(songEntity);
      session.getTransaction().commit();
    }
  }
}
