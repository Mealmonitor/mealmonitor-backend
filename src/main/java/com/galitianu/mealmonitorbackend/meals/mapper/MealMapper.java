package com.galitianu.mealmonitorbackend.meals.mapper;

import com.galitianu.mealmonitorbackend.common.mapper.BaseModelEntityMapper;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.MealEntity;
import com.galitianu.mealmonitorbackend.meals.service.model.Meal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealMapper extends BaseModelEntityMapper<Meal, MealEntity> {
}
