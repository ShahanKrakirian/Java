package com.shahan.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shahan.countries.services.ApiService;

@Controller
public class WorldController {
	private final ApiService apiService;
	
	public WorldController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public void query() {
		
		//All Slovene
//		List<Object[]> all = apiService.sloveneCountries();
//		for (Object[] obj : all) {
//			System.out.println((String) obj[0]);
//			System.out.println((String) obj[1]);
//			System.out.println((Double) obj[2]);
//		}
		
//		List<Object[]> all = apiService.citiesPerCountry();
//		for (Object[] obj : all) {
//			System.out.println("Country: ");
//			System.out.println((String) obj[0]);
//			System.out.println("# Cities: ");
//			System.out.println(obj[1]);
//		}
		
//		List<Object[]> all = apiService.citiesInMexico();
//		for (Object[] obj : all) {
//			System.out.println("City :");
//			System.out.println(obj[0]);
//			System.out.println("Population :");
//			System.out.println(obj[1]);
//		}
		
//		List<Object[]> all = apiService.languagesByPercentage();
//		for (Object[] obj : all) {
//			System.out.println("Country: ");
//			System.out.println(obj[0]);
//			System.out.println("Language: ");
//			System.out.println(obj[1]);
//			System.out.println("Percentage: ");
//			System.out.println(obj[2]);
//		}
		
//		List<Object[]> all = apiService.sizeAndPopulation();
//		for (Object[] obj : all) {
//			System.out.println("Country: ");
//			System.out.println(obj[0]);
//			System.out.println("Surface area: ");
//			System.out.println(obj[1]);
//			System.out.println("Population: ");
//			System.out.println(obj[2]);
//		}
		
//		List<Object[]> all = apiService.constMonarchy();
//		for (Object[] obj : all) {
//			System.out.println("Country: ");
//			System.out.println(obj[0]);
//			System.out.println("Government form: ");
//			System.out.println(obj[1]);
//			System.out.println("Surface area: ");
//			System.out.println(obj[2]);
//			System.out.println("Life expectancy: ");
//			System.out.println(obj[3]);
//		}
		
//		List<Object[]> all = apiService.buenosAiresDistrict();
//		for (Object[] obj : all) {
//			System.out.println("Country: ");
//			System.out.println(obj[0]);
//			System.out.println("District: ");
//			System.out.println(obj[1]);
//			System.out.println("City name: ");
//			System.out.println(obj[2]);
//			System.out.println("Population: ");
//			System.out.println(obj[3]);
//		}
		
		List<Object[]> all = apiService.countryCountPerRegion();
		for (Object[] obj : all) {
			System.out.println("Region: ");
			System.out.println(obj[0]);
			System.out.println("# of Countries: ");
			System.out.println(obj[1]);
		}
		
	}

}
