package audio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import audio.entities.AlbumEntity;
import audio.serviceImpl.AlbumServiceImpl;

/**
 * Created by Elvira on 11.10.2019.
 */
@Controller("/albums")
public class AlbumController {
  
  private AlbumServiceImpl albumService;

  @Autowired
  @Qualifier(value = "albumService")
  public void setAlbumService(AlbumServiceImpl albumService) {
    this.albumService = albumService;
  }

  @RequestMapping(value = "albums", method = RequestMethod.GET)
  public String listAlbums(@ModelAttribute("album") AlbumEntity album, Model model) {
    model.addAttribute("album", new AlbumEntity());
    model.addAttribute("albumList", this.albumService.listAlbums());
    return "albums";
  }

  @RequestMapping(value = "/albums/add", method = RequestMethod.POST)
  public String addAlbum(@ModelAttribute("album") AlbumEntity albumEntity, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("albumList", this.albumService.listAlbums());
      return "albums";
    }
    if (albumEntity.getIdAlbum() == 0) {
      this.albumService.addAlbum(albumEntity);
    } else {
      this.albumService.updateAlbum(albumEntity);
    }
    return "redirect:/albums";
  }

  @RequestMapping("/albums/delete/{id}")
  public String deleteAlbum(@PathVariable("id") long id) {
    this.albumService.deleteAlbum(id);
    return "redirect:/albums";
  }

  @RequestMapping("/albums/edit/{id}")
  public String editAlbum(@PathVariable("id") long id, Model model) {
    model.addAttribute("album", this.albumService.getAlbumById(id));
    model.addAttribute("albumList", this.albumService.listAlbums());
    return "albums";
  }

}
