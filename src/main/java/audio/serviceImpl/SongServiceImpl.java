package audio.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import audio.dao.SongDao;
import audio.entities.SongEntity;
import audio.service.SongService;

/**
 * Created by Elvira on 11.10.2019.
 */
@Service
public class SongServiceImpl implements SongService {

  public SongServiceImpl() {
  }

  @Autowired
  private SongDao songDao;

  public void setSongDao(SongDao songDao) {
    this.songDao = songDao;
  }

  @Override
  public void addSong(SongEntity song) {
    songDao.addSong(song);
  }

  @Override
  public void updateSong(SongEntity song) {
    songDao.updateSong(song);
  }

  @Override
  public SongEntity getSongById(long idSong) {
    return songDao.getSongById(idSong);
  }

  @Override
  public List listSongs() {
    return songDao.listSongs();
  }

  @Override
  public void deleteSong(long idSong) {
    songDao.deleteSong(idSong);
  }
}
