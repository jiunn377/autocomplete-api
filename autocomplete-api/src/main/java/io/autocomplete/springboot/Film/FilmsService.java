package io.autocomplete.springboot.Film;

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
public class FilmsService {
	
	@Autowired
	private FilmsRespository FlimsRespository;
	
	//for initial load - to load JSON data set to DB
	public void initialLoad(){
		try {
			 
				
				JSONParser parser = new JSONParser(); 
				JSONObject json = (JSONObject) parser.parse(new FileReader("FilmList.json"));
				
				@SuppressWarnings("unchecked")
				List booklist = new ArrayList((List) json.get("Films"));
				
				Films film = new Films();
				for (int i=0; i< booklist.size();i++){
					JSONObject booksDetail = (JSONObject)booklist.get(i);
					film.setId(booksDetail.get("id").toString());
					film.setfilm(booksDetail.get("film").toString());
					film.setActor(booksDetail.get("actor").toString());
					FlimsRespository.save(film);
				}
				
				
				
				
        } catch (Exception e) {
            e.printStackTrace();
        }
	
    }
	
	//list out all Film
	public List<Films> getAllFlim(){
		
		List<Films> film = new ArrayList<>();
		
		FlimsRespository.findAll().forEach(film::add);
		
		return film;
	}
	
	//get specific Film
	public Films getBook(String film){
		
		return FlimsRespository.findOne(film);  
		
	}
		
	//to filter 3 column
	public List<Films> getFilmFilter(String id,String film,String actor){
		
		List<Films> book = new ArrayList<>();
		FlimsRespository.findAllByIdStartingWithIgnoreCaseOrFilmStartingWithIgnoreCaseOrActorStartingWithIgnoreCase(id,film,actor).forEach(book::add);
		return book;
	}
	
	//to add Film - using POST
	public void addBook(Films film){
		
		FlimsRespository.save(film);
		
	}

	
}
