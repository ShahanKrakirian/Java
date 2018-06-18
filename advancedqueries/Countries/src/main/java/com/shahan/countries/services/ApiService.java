package com.shahan.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shahan.countries.models.Country;
import com.shahan.countries.repositories.CityRepository;
import com.shahan.countries.repositories.CountryRepository;
import com.shahan.countries.repositories.LanguageRepository;

@Service
public class ApiService {
	private final LanguageRepository languageRepository;
	private final CountryRepository countryRepository;
	private final CityRepository cityRepository;
	
	public ApiService(LanguageRepository languageRepository, CountryRepository countryRepository, CityRepository cityRepository) {
		this.languageRepository = languageRepository;
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
	}
	
	public List<Object[]> sloveneCountries(){
		return this.countryRepository.findAllSloveneCountries();
	}
	
	public List<Object[]> citiesPerCountry(){
		return this.countryRepository.citiesPerCountry();
	}
	
	public List<Object[]> citiesInMexico(){
		return this.countryRepository.citiesInMexico();
	}
	
	public List<Object[]> languagesByPercentage(){
		return this.countryRepository.languagesByPercentage();
	}
	
	public List<Object[]> sizeAndPopulation(){
		return this.countryRepository.sizeAndPopulation();
	}
	
	public List<Object[]>  constMonarchy(){
		return this.countryRepository.constMonarchy();
	}
	
	public List<Object[]> buenosAiresDistrict(){
		return this.countryRepository.buenosAiresDistrict();
	}
	
	public List<Object[]> countryCountPerRegion(){
		return this.countryRepository.countryCountPerRegion();
	}
	
}
