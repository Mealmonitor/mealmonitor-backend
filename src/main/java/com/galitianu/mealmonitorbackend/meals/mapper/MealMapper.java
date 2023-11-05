package com.galitianu.mealmonitorbackend.meals.mapper;

import com.galitianu.mealmonitorbackend.meals.api.dto.NewFoodDto;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.FoodEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealMapper {
    FoodEntity fromDto(NewFoodDto dto);
}
