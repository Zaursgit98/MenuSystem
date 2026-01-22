package com.zaurdadasov.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaurdadasov.config.Country;
import com.zaurdadasov.config.GlobalProperties;

@RestController
@RequestMapping("/api")
public class PropertySourceController {
    
	@Autowired
	private GlobalProperties properties;
	
	
	@GetMapping("/all")
	public List<Country>allCountries(){
		
		return properties.getCountries();
	}
	
}
