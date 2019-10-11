package audio.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Elvira on 11.10.2019.
 */
@Entity
@Table(name = "song", schema = "public", catalog = "audio")
public class SongEntity {
  private long idSong;
  private String nameSong;
  private String genreSong;
  private AlbumEntity songByAlbum;
  private SingerEntity songBySinger;

  @Id
  @Column(name = "id_song", nullable = false, unique = true)
  @GenericGenerator(name = "num", strategy = "increment")
  @GeneratedValue(generator = "num")
  public long getIdSong() {
    return idSong;
  }

  public void setIdSong(long idSong) {
    this.idSong = idSong;
  }

  @Basic
  @Column(name = "name_song")
  public String getNameSong() {
    return nameSong;
  }

  public void setNameSong(String nameSong) {
    this.nameSong = nameSong;
  }

  @Column(name = "genre_song")
  public String getGenreSong() {
    return genreSong;
  }

  public void setGenreSong(String genreSong) {
    this.genreSong = genreSong;
  }

  @ManyToOne(cascade= {CascadeType.REFRESH}, fetch= FetchType.LAZY)
  @JoinColumn(name = "album_song", referencedColumnName = "id_album")
  public AlbumEntity getSongByAlbum() {
    return songByAlbum;
  }

  public void setSongByAlbum(AlbumEntity songByAlbum) {
    this.songByAlbum = songByAlbum;
  }

  @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
  @JoinColumn(name = "singer_song", referencedColumnName = "id_singer")
  public SingerEntity getSongBySinger() {
    return songBySinger;
  }

  public void setSongBySinger(SingerEntity songBySinger) {
    this.songBySinger = songBySinger;
  }

  @Override
  public String toString() {
    return
        "idSong=" + this.getIdSong() +
            ", nameSong='" + this.getNameSong() + '\'' +
            ", songByAlbum=" + this.getSongByAlbum() +
            ", genreSong='" + this.getGenreSong() + '\'' +
            ", songBySinger=" + this.getSongBySinger();
  }
}
