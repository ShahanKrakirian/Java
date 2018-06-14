package com.shahan.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shahan.lookify.models.Song;
import com.shahan.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public Song createSong(Song song) {
    	return songRepository.save(song);
    }
	
	public List<Song> allSongs(){
		return songRepository.findAll();
	}
	
	public Song getSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	public List<Song> topTen(){
		return songRepository.findAllByOrderByRatingDesc();
	}
	
	public List<Song> search(String str){
		return songRepository.findByArtistContaining(str);
	}

}
