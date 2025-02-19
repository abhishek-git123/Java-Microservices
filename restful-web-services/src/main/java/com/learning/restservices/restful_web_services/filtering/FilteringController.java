package com.learning.restservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filter")
	public MappingJacksonValue filtering() {		
		TestBean testBean = new TestBean("value1","value2","value3");
		MappingJacksonValue jacksonValue = new MappingJacksonValue(testBean);		
		FilterProvider filters = createFilter("field1","field3");		
		jacksonValue.setFilters(filters);
		return jacksonValue;
	}

	
	@GetMapping("/filterList")
	public MappingJacksonValue filteringList() {	
		List<TestBean> listOfTestBean =  Arrays.asList(new TestBean("value1","value2","value3"),
				new TestBean("value11","value22","value33"),
				new TestBean("value111","value222","value333"));
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(listOfTestBean);				
		FilterProvider filters = createFilter("field3","field2");
		jacksonValue.setFilters(filters);
		
		return jacksonValue;
	}
	
	private FilterProvider createFilter(String firstField, String secondField) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(firstField, secondField);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		return filters;
	}
	
}
