package io.autocomplete.springboot.Books;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	@Autowired
	private BooksService bookSrv;
	
	//set all Books and load data after set
	@RequestMapping("/Books")
	public List<Books> getAllBooks(){
		bookSrv.initialLoad();
		return bookSrv.getAllBook();
		
	}
	
	//filtering dataset with 3 column
	@RequestMapping("/Books/{author}&{name}&{series}")
	public List<Books> getBooks(
			@PathVariable("author") String author,
			@PathVariable("name")String name,
			@PathVariable("series") String series){
	
		return bookSrv.getAuthor(author,name,series);
	}
	
	//set/add 1 dataset
	@RequestMapping(method=RequestMethod.POST, value="/Books")
	public void setBooks(@RequestBody Books book){
		
		bookSrv.addBook(book);
	}
	
}
