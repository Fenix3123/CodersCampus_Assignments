package com.coderscampus.Assignment9.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;

@Service
public class recipeMaker {
	
	public List<Recipe> readFile() throws IOException{
		
		
		List<Recipe> recipeList = new ArrayList<>();
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Fenix Xia\\Documents\\GitHub\\CodersCampus_Assignments\\Assignment9\\src\\main\\java\\com\\coderscampus\\Assignment9\\recipes.txt"));
		in.readLine();
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian").parse(in);
		for (CSVRecord record : records) {
			Integer cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
			Boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
			Boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
			String instructions = record.get("Instructions");
			Double preperationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
			Double pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
			Integer readyInMinutes = Integer.parseInt(record.get("Ready In Minutes"));
			Integer servings = Integer.parseInt(record.get("Servings"));
			Double spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
			String title = record.get("Title");
			Boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
			Boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));
			
			
		    recipeList.add(new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preperationMinutes, pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian));
		}
		return recipeList;
	}
}
