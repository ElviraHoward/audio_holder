package audio.service;

import java.util.List;

import audio.entities.SongEntity;

/**
 * Created by Elvira on 11.10.2019.
 */
public interface SongService {

  public void addSong(SongEntity song);

  public void updateSong(SongEntity song);

  public SongEntity getSongById(long idSong);

  public List listSongs();

  public void deleteSong(long idSong);
}
