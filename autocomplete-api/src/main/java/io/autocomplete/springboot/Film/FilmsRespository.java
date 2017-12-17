package io.autocomplete.springboot.Film;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FilmsRespository extends CrudRepository<Films, String>{

	//JPA to filter more 3 column
	List<Films> findAllByIdStartingWithIgnoreCaseOrFilmStartingWithIgnoreCaseOrActorStartingWithIgnoreCase(String id,String film,String actor);
	
}
