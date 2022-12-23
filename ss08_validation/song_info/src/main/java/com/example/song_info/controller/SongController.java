package com.example.song_info.controller;

import com.example.song_info.dto.SongDto;
import com.example.song_info.model.Song;
import com.example.song_info.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("listSong",iSongService.findALl(pageable));
        return "song/list";
    }

    @GetMapping("/create")
    public String createSong(Model model){
        model.addAttribute("songDto",new SongDto());
        return "song/create";
    }

    @PostMapping("/save")
    public String saveSong(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "song/create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.save(song);
            return "redirect:/song";
        }
    }
}
