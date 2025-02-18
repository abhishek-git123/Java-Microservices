package com.learning.restservices.restful_web_services.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filter")
	public TestBean filtering() {
		return new TestBean("value1","value2","value3");
	}
}
