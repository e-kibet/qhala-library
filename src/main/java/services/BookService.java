package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return bookRepository.findById(id).get();
    }
    
    public void deleteBookById(Integer id) {
    	bookRepository.deleteById(id);
    }
    

}
