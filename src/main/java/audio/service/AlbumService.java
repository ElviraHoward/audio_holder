package audio.service;

import java.util.List;

import audio.entities.AlbumEntity;

/**
 * Created by Elvira on 11.10.2019.
 */
public interface AlbumService {

  public void addAlbum(AlbumEntity album);

  public void updateAlbum(AlbumEntity album);

  public AlbumEntity getAlbumById(long idAlbum);

  public List listAlbums();

  public void deleteAlbum(long idAlbum);
}
