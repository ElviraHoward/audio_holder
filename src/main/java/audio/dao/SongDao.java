package audio.dao;

import audio.entities.SongEntity;

import java.util.List;

/**
 * Created by Elvira on 11.10.2019.
 */
public interface SongDao {

  public void addSong(SongEntity song);

  public void updateSong(SongEntity song);

  public SongEntity getSongById(long idSong);

  public List listSongs();

  public void deleteSong(long idSong);
}
