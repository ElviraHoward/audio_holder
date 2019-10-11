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

import audio.entities.SingerEntity;
import audio.serviceImpl.SingerServiceImpl;

/**
 * Created by Elvira on 11.10.2019.
 */
@Controller("/singers")
public class SingerController {
  
  private SingerServiceImpl singerService;

  @Autowired
  @Qualifier(value = "singerService")
  public void setSingerService(SingerServiceImpl singerService) {
    this.singerService = singerService;
  }

  @RequestMapping(value = "singers", method = RequestMethod.GET)
  public String listSingers(@ModelAttribute("singer") SingerEntity singer, Model model) {
    model.addAttribute("singer", new SingerEntity());
    model.addAttribute("singerList", this.singerService.listSingers());
    return "singers";
  }

  @RequestMapping(value = "/singers/add", method = RequestMethod.POST)
  public String addSinger(@ModelAttribute("singer") SingerEntity singerEntity, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("singerList", this.singerService.listSingers());
      return "singers";
    }
    if (singerEntity.getIdSinger() == 0) {
      this.singerService.addSinger(singerEntity);
    } else {
      this.singerService.updateSinger(singerEntity);
    }
    return "redirect:/singers";
  }

  @RequestMapping("/singers/delete/{id}")
  public String deleteSinger(@PathVariable("id") long id) {
    this.singerService.deleteSinger(id);
    return "redirect:/singers";
  }

  @RequestMapping("/singers/edit/{id}")
  public String editSinger(@PathVariable("id") long id, Model model) {
    model.addAttribute("singer", this.singerService.getSingerById(id));
    model.addAttribute("singerList", this.singerService.listSingers());
    return "singers";
  }

}
