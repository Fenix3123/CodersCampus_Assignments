package com.example.Assignment10.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayResponse {
	@JsonProperty("meals")
	private List<meals> mealData;
	private nutrientData nutrients;
	
	public nutrientData getNutrients() {
		return nutrients;
	}

	public void setNutrients(nutrientData nutrients) {
		this.nutrients = nutrients;
	}

	public List<meals> getMealData(){
		return mealData;
	}
	
	public void setMealData(List<meals> mealData) {
		this.mealData = mealData;
	}
}
