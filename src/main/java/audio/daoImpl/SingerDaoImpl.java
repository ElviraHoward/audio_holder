package audio.daoImpl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import audio.HibernateSessionFactory;
import audio.dao.SingerDao;
import audio.entities.SingerEntity;

/**
 * Created by Elvira on 11.10.2019.
 */
@Repository
public class SingerDaoImpl implements SingerDao {

  private SingerDao singerDao;

  public SingerDaoImpl(SingerDao singerDao) {
    this.singerDao = singerDao;
  }

  public SingerDaoImpl() {
  }

  @Override
  public void addSinger(SingerEntity singer) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(singer);
    session.getTransaction().commit();
  }

  @Override
  public void updateSinger(SingerEntity singer) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.merge(singer);
    session.getTransaction().commit();
  }

  @Override
  public SingerEntity getSingerById(long idSinger) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    return (SingerEntity) session.load(SingerEntity.class, idSinger);
  }

  @Override
  public List listSingers() {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    return session.createQuery("from SingerEntity ").list();
  }

  @Override
  public void deleteSinger(long idSinger) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    SingerEntity singerEntity = (SingerEntity) session.load(SingerEntity.class, idSinger);
    if (singerEntity != null) {
      session.beginTransaction();
      session.delete(singerEntity);
      session.getTransaction().commit();
    }
  }
}
