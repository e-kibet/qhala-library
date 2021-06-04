package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import models.Book;
import repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid book with id %s", id)));
    }
    
    public void deleteBookById(Integer id) {
    	bookRepository.deleteById(id);
    }
    

}
