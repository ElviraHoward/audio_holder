package audio.dao;

import audio.entities.SingerEntity;

import java.util.List;

/**
 * Created by Elvira on 11.10.2019.
 */
public interface SingerDao {
  
  public void addSinger(SingerEntity singer);

  public void updateSinger(SingerEntity singer);

  public SingerEntity getSingerById(long idSinger);

  public List listSingers();

  public void deleteSinger(long idSinger);
}
