package com.learning.restservices.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	private MessageSource messsageSource;
	
	public HelloWorldController(MessageSource mesageSource) {
		this.messsageSource = mesageSource;
	}
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello-World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
		
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World, " + name);
	}
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messsageSource.getMessage("good.morning.message", null, "Default message", locale);
		//return "Hello-World V2";
	}

}
