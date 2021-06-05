package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import models.Book;
import repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public ResponseEntity<Map<String, Object>> getAllBooks(int page, int size){
		try {
			List<Book> books = new ArrayList<Book>();
		    Pageable paging = PageRequest.of(page, size);
	
		      Page<Book> pageTuts = bookRepository.findAll(paging);
		      books = pageTuts.getContent();
		      Map<String, Object> response = new HashMap<>();
		      response.put("books", books);
		      response.put("currentPage", pageTuts.getNumber());
		      response.put("totalItems", pageTuts.getTotalElements());
		      response.put("totalPages", pageTuts.getTotalPages());

		      return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
