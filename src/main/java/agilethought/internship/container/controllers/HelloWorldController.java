package agilethought.internship.container.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String inicio( ) {
		return "Hello, this is my first spring boot application";
	}


}
