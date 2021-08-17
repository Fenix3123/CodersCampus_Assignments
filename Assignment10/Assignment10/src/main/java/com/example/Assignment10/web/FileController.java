package com.example.Assignment10.web;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Assignment10.dto.DayResponse;
import com.example.Assignment10.dto.WeekResponse;

@RestController
public class FileController {
	
	//for test
	@GetMapping("")
	public String helloworld() {
		return "Hello world";
	}
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions){
		RestTemplate rt = new RestTemplate();
		
		URI uri =  UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									   .queryParam("timeFrame", "week")
									   .queryParam("targetCalories", Integer.parseInt(numCalories))
									   .queryParam("diet", diet)
									   .queryParam("exclude", exclusions)
									   .queryParam("apiKey", "091f58dff1d24c82b88982fef35d326c")
									   .build()
									   .toUri();
		
		ResponseEntity<WeekResponse> getWeekmeal = rt.getForEntity(uri, WeekResponse.class);
		System.out.print(getWeekmeal.getBody());
		return getWeekmeal;
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions){
		RestTemplate rt = new RestTemplate();
				
				URI uri =  UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
											   .queryParam("timeFrame", "day")
											   .queryParam("targetCalories", Integer.parseInt(numCalories))
											   .queryParam("diet", diet)
											   .queryParam("exclude", exclusions)
											   .queryParam("apiKey", "091f58dff1d24c82b88982fef35d326c")
											   .build()
											   .toUri();
				
				ResponseEntity<DayResponse> getDayMeal = rt.getForEntity(uri, DayResponse.class);
				System.out.print(getDayMeal.getBody());
				return getDayMeal;
	}
}
