package audio.daoImpl;

import audio.HibernateSessionFactory;
import audio.dao.AlbumDao;
import audio.entities.AlbumEntity;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elvira on 11.10.2019.
 */

@Repository
public class AlbumDaoImpl implements AlbumDao {

  private AlbumDao albumDao;

  public AlbumDaoImpl(AlbumDao actorDao) {
    this.albumDao = albumDao;
  }

  public AlbumDaoImpl() {
  }

  @Override
  public void addAlbum(AlbumEntity album) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(album);
    session.getTransaction().commit();
  }

  @Override
  public void updateAlbum(AlbumEntity album) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.merge(album);
    session.getTransaction().commit();
  }

  @Override
  public AlbumEntity getAlbumById(long idAlbum) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    return (AlbumEntity) session.load(AlbumEntity.class, idAlbum);
  }

  @Override
  public List listAlbums() {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    return session.createQuery("from AlbumEntity ").list();
  }

  @Override
  public void deleteAlbum(long idAlbum) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    AlbumEntity albumEntity = (AlbumEntity) session.load(AlbumEntity.class, idAlbum);
    if(albumEntity!=null){
      session.beginTransaction();
      session.delete(albumEntity);
      session.getTransaction().commit();
    }
  }
}
