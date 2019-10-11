package audio.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import audio.dao.SingerDao;
import audio.entities.SingerEntity;
import audio.service.SingerService;

/**
 * Created by Elvira on 11.10.2019.
 */
@Service
public class SingerServiceImpl implements SingerService {

  @Autowired
  private SingerDao singerDao;

  public void setSingerDao(SingerDao singerDao) {
    this.singerDao = singerDao;
  }

  @Override
  public void addSinger(SingerEntity singer) {
    singerDao.addSinger(singer);
  }

  @Override
  public void updateSinger(SingerEntity singer) {
    singerDao.updateSinger(singer);
  }

  @Override
  public SingerEntity getSingerById(long idSinger) {
    return singerDao.getSingerById(idSinger);
  }

  @Override
  public List listSingers() {
    return singerDao.listSingers();
  }

  @Override
  public void deleteSinger(long idSinger) {
    singerDao.deleteSinger(idSinger);
  }
}
