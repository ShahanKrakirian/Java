package com.shahan.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shahan.lookify.models.Song;
import com.shahan.lookify.services.SongService;

@Controller
public class MainController {
	private final SongService songService;
	
	public MainController(SongService songService) {
		this.songService = songService;
	}

	@RequestMapping("/")
	public String welcome(){
		return "/lookify/welcome.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/lookify/dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("songToAdd") Song song) {
		return "/lookify/newSong.jsp";
	}
//	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String newSongProcess(@Valid @ModelAttribute("songToAdd") Song song, BindingResult result) {
		if (result.hasErrors()){
			return "/lookify/newSong.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String songDetails(@PathVariable("id") Long id, Model model) {
		Song currSong = songService.getSong(id);
		model.addAttribute("song", currSong);
		return "/lookify/songDetails.jsp";
	}
	
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> currSongs = songService.topTen();
		model.addAttribute("songs", currSongs);
		return "/lookify/topTen.jsp";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("search") String search, Model model) {
		List<Song> searchSongs = songService.search(search);
		model.addAttribute("searchSongs", searchSongs);
		return "/lookify/search.jsp";
	}
}
