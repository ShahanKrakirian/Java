package com.shahan.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shahan.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	
	List<Song> findAll();
	
	Optional<Song> findById(Long id);
		
	void deleteById(Long id);
	
	List<Song> findAllByOrderByRatingDesc();
	
	List<Song> findByArtistContaining(String str);

}
