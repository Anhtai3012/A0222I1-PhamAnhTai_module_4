package codegym.controller;

import codegym.model.Song;
import codegym.service.ISongService;
import codegym.service.impl.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class SongController {

    //ISongService iSongService = new SongService();
    @Autowired
    private ISongService iSongService;

    @RequestMapping("")
    public String ShowList(Model model){
        model.addAttribute("song",iSongService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String ShowCreate(Model model){
            model.addAttribute("song",new Song() );
        return "/create";
    }
    @PostMapping("/save")
    public String addNew(RedirectAttributes redirectAttributes,@ModelAttribute("song") Song song){
        iSongService.save(song);
        return "redirect:/";
    }
}
