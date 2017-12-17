package io.autocomplete.springboot.Film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.autocomplete.springboot.Books.Books;

@RestController
public class FilmsController {

	@Autowired
	private FilmsService filmSrv;
	
	//get all Film
	@RequestMapping("/Films")
	public List<Films> getAllFilms(){
		filmSrv.initialLoad();
		return filmSrv.getAllFlim();
		
	}
	
	//set all Film and load data after set
	@RequestMapping("/setFilms")
	public List<Films> setAllFilms(){
		filmSrv.initialLoad();
		return filmSrv.getAllFlim();
		
	}
	
	//filtering dataset with 3 column
	@RequestMapping("/Films/{id}&{film}&{actor}")
	public List<Films> getFilms(
			@PathVariable("id") String id,
			@PathVariable("film")String film,
			@PathVariable("actor") String actor){
	
		return filmSrv.getFilmFilter(id, film, actor);
	}
	
	//set/add 1 dataset
	@RequestMapping(method=RequestMethod.POST, value="/Flims")
	public void setBooks(@RequestBody Films film){
		
		filmSrv.addBook(film);
	}
	
}
