package com.shahan.dojosninjas.services;

import org.springframework.stereotype.Service;

import com.shahan.dojosninjas.models.Ninja;
import com.shahan.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

}
