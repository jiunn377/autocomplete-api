package io.autocomplete.springboot.Books;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BooksRespository extends CrudRepository<Books, String>{

	//JPA to filter more 3 column
	List<Books> findAllByAuthorStartingWithIgnoreCaseOrNameStartingWithIgnoreCaseOrSeriesStartingWithIgnoreCase(String author,String name,String series);
	
}
