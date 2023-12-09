package com.galitianu.mealmonitorbackend.meals.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewFoodDto {
    private String barCode;
    private String name;
    private String brand;
    private String unitOfMeasurement;
    private Long quantity;
    private Long calories;
    private Long proteins;
    private Long carbs;
    private Long fats;
}
