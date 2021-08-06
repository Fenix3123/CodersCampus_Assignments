package com.coderscampus.Assignment9.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.recipeMaker;
import com.coderscampus.Assignment9.domain.Recipe;


@RestController
public class FileController {
	@Autowired
	private recipeMaker reader;
	
	@GetMapping("/all-recipes")
	public void returnAll() throws IOException{
		List<Recipe> recipes = reader.readFile();
		
		for(Recipe item: recipes) {
			System.out.println(item);
		}
		
	}
}
