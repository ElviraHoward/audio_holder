package audio.service;

import java.util.List;

import audio.entities.SingerEntity;

/**
 * Created by Elvira on 11.10.2019.
 */
public interface SingerService {

  public void addSinger(SingerEntity singer);

  public void updateSinger(SingerEntity singer);

  public SingerEntity getSingerById(long idSinger);

  public List listSingers();

  public void deleteSinger(long idSinger);
}
