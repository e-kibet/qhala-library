package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import models.Book;
import responses.ApiResponse;
import services.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	
	@Autowired
	private ApiResponse apiResponse;
	@Autowired
	private BookService bookService;
	
	@PostMapping("/books")
	public HashMap<String, Object> createBook(@Valid @RequestBody  Book book) {
		bookService.saveBook(book);
		return apiResponse.apiResponse(true, 200, "Book has been created");
	}
	
	@GetMapping("/books")
	public ResponseEntity<Map<String, Object>> getAllBooks(@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size){
		return bookService.getAllBooks(page, size);
	}
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookByID(@PathVariable Integer id) {
	    try {
	        Book product = bookService.getBookById(id);
	        return new ResponseEntity<Book>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/books/{id}")
	public HashMap<String, Object>  deleteBookByID(@PathVariable Integer id) {
		bookService.deleteBookById(id);
		return apiResponse.apiResponse(true, 200, "Book has been deleted successfully");
		
	}

}
