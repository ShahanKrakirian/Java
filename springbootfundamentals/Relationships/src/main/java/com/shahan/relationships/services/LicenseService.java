package com.shahan.relationships.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.shahan.relationships.models.License;
import com.shahan.relationships.models.Person;
import com.shahan.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public License latestLicense() {
		Optional<License> optionalLicense = licenseRepository.findFirstByOrderByIdDesc();
		if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
	}
}

