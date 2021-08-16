package com.coderscampus.Assignment9.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.recipeMaker;


@RestController
public class FileController {
	@Autowired
	private recipeMaker reader;
	
	@GetMapping("/all-recipes")
	public List<Recipe> returnAll() throws IOException{
		List<Recipe> recipes = reader.readFile();
		
		for(Recipe item: recipes) {
			System.out.println(item);
		}
		
		return recipes;
		
		
	}
	
	@GetMapping("/vegan")
	public List<Recipe> returnVegan() throws IOException{
		//List<Recipe> recipes = reader.readFile();
		List<Recipe> recipes_vegan = reader.readFile().stream()
													  .filter(vegan -> vegan.getVegan() == true)
													  .toList();
		
		for(Recipe item: recipes_vegan) {
			System.out.println(item);
		}
		
		return recipes_vegan;
		
	}
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> returnVeganAndGlutenFree() throws IOException{
		//List<Recipe> recipes = reader.readFile();
		List<Recipe> recipes_vg = reader.readFile().stream()
													  .filter(item -> item.getVegan() == true && item.getGlutenFree() == true)
													  .toList();
		
		for(Recipe item: recipes_vg) {
			System.out.println(item);
		}
		
		return recipes_vg;
		
	}
	
	@GetMapping("/vegetarian")
	public List<Recipe> returnVegetarian() throws IOException{
		//List<Recipe> recipes = reader.readFile();
		List<Recipe> recipes_veg = reader.readFile().stream()
													.filter(item -> item.getVegetarian() == true)
													.toList();
		
		for(Recipe item: recipes_veg) {
			System.out.println(item);
		}
		
		return recipes_veg;
		
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> returnGlutenFree() throws IOException{
		//List<Recipe> recipes = reader.readFile();
		List<Recipe> recipes_Gfree = reader.readFile().stream()
													.filter(item -> item.getGlutenFree() == true)
													.toList();
		
		for(Recipe item: recipes_Gfree) {
			System.out.println(item);
		}
		
		return recipes_Gfree;
		
	}
}
