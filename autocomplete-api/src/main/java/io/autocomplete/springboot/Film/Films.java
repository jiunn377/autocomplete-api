package io.autocomplete.springboot.Film;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
public class Films {
	
	//Entity/Getter/Setter sets
	@Id
	@Column(name="id")
	private String id;

	@Column(name="films",columnDefinition="VARCHAR(1000)")
	private String film;
	
	@Column(name="actor")
	private String actor;
	
	public Films(){
		
	}
	public Films(String id, String film , String actor){
		super();
		this.id = id;
		this.film = film;
		this.actor = actor;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getfilm() {
		return film;
	}
	public void setfilm(String film) {
		this.film = film;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
}