package com.galitianu.mealmonitorbackend.meals.api.dto;

import com.galitianu.mealmonitorbackend.meals.persistance.entity.FoodEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
