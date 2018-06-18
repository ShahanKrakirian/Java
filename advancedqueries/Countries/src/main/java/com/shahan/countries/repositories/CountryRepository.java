package com.shahan.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shahan.countries.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{
	
	@Query(value="SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.language desc")
	List<Object[]> findAllSloveneCountries();
	
	@Query(value="SELECT c.name, count(city.id) FROM Country c JOIN c.cities city GROUP BY c.name  ORDER BY count(city.id) desc")
	List<Object[]> citiesPerCountry();
	
	@Query(value="SELECT city.name, city.population FROM Country c JOIN c.cities city WHERE c.name = 'Mexico' ORDER BY city.population desc")
	List<Object[]> citiesInMexico();
	
	@Query(value="SELECT c.name, lang.language, lang.percentage FROM Country c JOIN c.languages lang WHERE lang.percentage > 89 ORDER BY lang.percentage desc")
	List<Object[]> languagesByPercentage();
	
	@Query(value="SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area < 501 AND c.population > 100000")
	List<Object[]> sizeAndPopulation();
	
	@Query(value="SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.surface_area > 200 AND c.life_expectancy > 75")
	List<Object[]> constMonarchy();
	
	@Query(value="SELECT c.name, city.district, city.name, city.population FROM Country c JOIN c.cities city WHERE c.name = 'Argentina' AND city.district = 'Buenos Aires' AND city.population > 500000")
	List<Object[]> buenosAiresDistrict();
	
	@Query(value="SELECT c.region, count(c.name) FROM Country c GROUP BY c.region ORDER BY count(c.name) desc")
	List<Object[]> countryCountPerRegion();

}
