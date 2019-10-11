package audio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.beans.PropertyEditorSupport;

import audio.entities.AlbumEntity;
import audio.entities.SingerEntity;
import audio.entities.SongEntity;
import audio.service.AlbumService;
import audio.service.SingerService;
import audio.service.SongService;

/**
 * Created by Elvira on 11.10.2019.
 */
@Controller("/songs")
public class SongController {

  private SongService songService;
  private SingerService singerService;
  private AlbumService albumService;

  @Autowired
  @Qualifier(value = "songService")
  public void setSongService(SongService songService) {
    this.songService = songService;
  }

  @Autowired
  @Qualifier(value = "singerService")
  public void setSingerService(SingerService singerService) {
    this.singerService = singerService;
  }

  @Autowired
  @Qualifier(value = "albumService")
  public void setAlbumService(AlbumService albumService) {
    this.albumService = albumService;
  }

  @RequestMapping(value = "songs", method = RequestMethod.GET)
  public String listSongs(Model model) {
    model.addAttribute("song", new SongEntity());
    model.addAttribute("songList", this.songService.listSongs());
    model.addAttribute("albumList", this.albumService.listAlbums());
    model.addAttribute("singerList", this.singerService.listSingers());

    return "songs";
  }

  @RequestMapping(value = "/songs/add", method = RequestMethod.POST)
  public String addSong(@ModelAttribute("song") SongEntity songEntity, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("songList", this.songService.listSongs());
      return "songs";
    }
    if (songEntity.getIdSong() == 0) {
      this.songService.addSong(songEntity);
    } else {
      this.songService.updateSong(songEntity);
    }
    return "redirect:/songs";
  }

  @RequestMapping("/songs/delete/{id}")
  public String deleteSong(@PathVariable("id") long id) {
    this.songService.deleteSong(id);
    return "redirect:/songs";
  }

  @RequestMapping("/songs/edit/{id}")
  public String editSong(@PathVariable("id") long id, Model model) {
    model.addAttribute("song", this.songService.getSongById(id));
    model.addAttribute("songList", this.songService.listSongs());
    model.addAttribute("albumList", this.albumService.listAlbums());
    model.addAttribute("singerList", this.singerService.listSingers());

    return "songs";
  }

  class AlbumEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text){
      Long id = Long.parseLong(text);
      AlbumEntity albumEntity = albumService.getAlbumById(id);
      setValue(albumEntity);
    }
  }

  class SingerEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text){
      Long id = Long.parseLong(text);
      SingerEntity singerEntity = singerService.getSingerById(id);
      setValue(singerEntity);
    }
  }

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(AlbumEntity.class, new AlbumEditor());
    binder.registerCustomEditor(SingerEntity.class, new SingerEditor());
  }
}
