package audio.entities;

import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Elvira on 11.10.2019.
 */
@Entity
@Table(name = "album", schema = "public", catalog = "audio")
public class AlbumEntity {
  private long idAlbum;
  private String nameAlbum;
  private Integer songsCountAlbum;
  private Integer yearAlbum;
  private Set<SongEntity> albumBySong;

  @Id
  @Column(name = "id_album")
  @GenericGenerator(name = "num", strategy = "increment")
  @GeneratedValue(generator = "num")
  public long getIdAlbum() {
    return idAlbum;
  }

  public void setIdAlbum(long idAlbum) {
    this.idAlbum = idAlbum;
  }

  @Basic
  @Column(name = "name_album")
  public String getNameAlbum() {
    return nameAlbum;
  }

  public void setNameAlbum(String nameAlbum) {
    this.nameAlbum = nameAlbum;
  }

  @Basic
  @Column(name = "songs_count_album")
  public Integer getSongsCountAlbum() {
    return songsCountAlbum;
  }

  public void setSongsCountAlbum(Integer songsCountAlbum) {
    this.songsCountAlbum = songsCountAlbum;
  }

  @Basic
  @Column(name = "year_album")
  public Integer getYearAlbum() {
    return yearAlbum;
  }

  public void setYearAlbum(Integer yearAlbum) {
    this.yearAlbum = yearAlbum;
  }

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "songByAlbum")
  public Set<SongEntity> getAlbumBySong() {
    return albumBySong;
  }

  public void setAlbumBySong(Set<SongEntity> albumBySong) {
    this.albumBySong = albumBySong;
  }

  @Override
  public String toString() {
    return nameAlbum;
  }
}
