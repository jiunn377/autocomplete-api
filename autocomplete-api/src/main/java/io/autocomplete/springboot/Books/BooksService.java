package io.autocomplete.springboot.Books;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Service
public class BooksService {
	
	@Autowired
	private BooksRespository bookRespository;

	//for initial load - to load JSON data set to DB
	public void initialLoad(){
		try {
			 
				JSONParser parser = new JSONParser(); 
				JSONObject json = (JSONObject) parser.parse(new FileReader("Booklist.json"));
				
				@SuppressWarnings("unchecked")
				List booklist = new ArrayList((List) json.get("Booklist"));
				
				Books book = new Books();
				for (int i=0; i< booklist.size();i++){
					JSONObject booksDetail = (JSONObject)booklist.get(i);
					book.setAuthor(booksDetail.get("author").toString());
					book.setName(booksDetail.get("name").toString());
					book.setSeries(booksDetail.get("series").toString());
					bookRespository.save(book);
				}
				
				
				
				
        } catch (Exception e) {
            e.printStackTrace();
        }
	
    }
	
	//list out all Books
	public List<Books> getAllBook(){
		
		List<Books> book = new ArrayList<>();
		
		bookRespository.findAll().forEach(book::add);
		
		return book;
		
	}
	
	//get specific Book
	public Books getBook(String book){
		
		return bookRespository.findOne(book);  
		
	}
	//to filter 3 column
	public List<Books> getAuthor(String author,String name,String series){
		
		List<Books> book = new ArrayList<>();
		bookRespository.findAllByAuthorStartingWithIgnoreCaseOrNameStartingWithIgnoreCaseOrSeriesStartingWithIgnoreCase(author,name,series).forEach(book::add);
		return book;
		
	}
	
	//to add Film - using POST
	public void addBook(Books book){
		bookRespository.save(book);
		
	}
	

	
}
