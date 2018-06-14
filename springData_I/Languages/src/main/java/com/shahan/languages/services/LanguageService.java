package com.shahan.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shahan.languages.models.Language;
import com.shahan.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    
    public Language createLanguage(Language lang) {
    	return languageRepository.save(lang);
    }
    
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
    
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
    	Language currLang = findLanguage(id);
    	currLang.setName(name);
    	currLang.setCreator(creator);
    	currLang.setCurrentVersion(currentVersion);
    	return languageRepository.save(currLang);
    }


}
