package com.galitianu.mealmonitorbackend.meals.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class NewMealDto {
    private ZonedDateTime dateTime;
    private List<NewFoodDto> foodList;
}
