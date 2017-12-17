package io.autocomplete.springboot.Books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
public class Books {

	//Entity/Getter/Setter sets
	@Id
	@Column(name="author")
	private String author;
	
	@Column(name="name",columnDefinition="VARCHAR(1000)")
	private String name;
	
	@Column(name="series")
	private String series;
	
	public Books(){
		
	}
	public Books(String author, String name , String series){
		super();
		this.author = author;
		this.name = name;
		this.series = series;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}

}