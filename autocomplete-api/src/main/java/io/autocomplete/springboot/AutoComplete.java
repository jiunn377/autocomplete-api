package io.autocomplete.springboot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import io.autocomplete.springboot.Books.*;
import io.autocomplete.springboot.Film.*;

@SpringBootApplication
public class AutoComplete {

	public static void main(String[] args) {
		
		/** -setup default config
			-start spring app context
			-perform classpath scan
			-start tomcat server      **/
		
		SpringApplication.run(AutoComplete.class, args);
		
	}

}
