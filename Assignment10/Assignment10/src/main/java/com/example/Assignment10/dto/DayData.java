package com.example.Assignment10.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayData {
	@JsonProperty("meals")
	private List<Meals> mealData;
	private NutrientData nutrients;
	
	public NutrientData getNutrients() {
		return nutrients;
	}

	public void setNutrients(NutrientData nutrients) {
		this.nutrients = nutrients;
	}

	public List<Meals> getMealData(){
		return mealData;
	}
	
	public void setMealData(List<Meals> mealData) {
		this.mealData = mealData;
	}
}
