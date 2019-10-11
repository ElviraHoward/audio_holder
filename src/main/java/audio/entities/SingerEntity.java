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
@Table(name = "singer", schema = "public", catalog = "audio")
public class SingerEntity {
  private long idSinger;
  private String nameSinger;
  private Integer ageSinger;
  private Set<SongEntity> singerBySong;

  @Id
  @Column(name = "id_singer")
  @GenericGenerator(name = "num", strategy = "increment")
  @GeneratedValue(generator = "num")
  public long getIdSinger() {
    return idSinger;
  }

  public void setIdSinger(long idSinger) {
    this.idSinger = idSinger;
  }

  @Basic
  @Column(name = "name_singer")
  public String getNameSinger() {
    return nameSinger;
  }

  public void setNameSinger(String nameSinger) {
    this.nameSinger = nameSinger;
  }

  @Basic
  @Column(name = "age_singer")
  public Integer getAgeSinger() {
    return ageSinger;
  }

  public void setAgeSinger(Integer ageSinger) {
    this.ageSinger = ageSinger;
  }

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "songBySinger")
  public Set<SongEntity> getSingerBySong() {
    return singerBySong;
  }

  public void setSingerBySong(Set<SongEntity> singerBySong) {
    this.singerBySong = singerBySong;
  }

  @Override
  public String toString() {
    return nameSinger;
  }
}
