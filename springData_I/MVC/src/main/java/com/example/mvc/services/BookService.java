package com.example.mvc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mvc.models.Book;
import com.example.mvc.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book toSave = findBook(id);
    	toSave.setTitle(title);
    	toSave.setDescription(desc);
    	toSave.setLanguage(lang);
    	toSave.setNumberOfPages(numOfPages);
    	return bookRepository.save(toSave);
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
