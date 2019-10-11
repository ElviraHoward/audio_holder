package audio.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import audio.dao.AlbumDao;
import audio.entities.AlbumEntity;
import audio.service.AlbumService;

/**
 * Created by Elvira on 11.10.2019.
 */
@Service
public class AlbumServiceImpl implements AlbumService {

  @Autowired
  private AlbumDao albumDao;

  public void setAlbumDao(AlbumDao albumDao) {
    this.albumDao = albumDao;
  }

  public AlbumServiceImpl() {
  }

  @Override
  public void addAlbum(AlbumEntity album) {
    albumDao.addAlbum(album);
  }

  @Override
  public void updateAlbum(AlbumEntity album) {
    albumDao.updateAlbum(album);
  }

  @Override
  public AlbumEntity getAlbumById(long idAlbum) {
    return albumDao.getAlbumById(idAlbum);
  }

  @Override
  public List listAlbums() {
    return albumDao.listAlbums();
  }

  @Override
  public void deleteAlbum(long idAlbum) {
    albumDao.deleteAlbum(idAlbum);
  }
}
