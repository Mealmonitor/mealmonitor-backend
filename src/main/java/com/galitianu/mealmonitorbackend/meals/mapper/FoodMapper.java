package com.galitianu.mealmonitorbackend.meals.mapper;

import com.galitianu.mealmonitorbackend.common.mapper.BaseModelEntityMapper;
import com.galitianu.mealmonitorbackend.meals.api.dto.FoodDto;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.FoodEntity;
import com.galitianu.mealmonitorbackend.meals.service.model.Food;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodMapper extends BaseModelEntityMapper<Food, FoodEntity> {
    FoodDto mapToDto(Food food);
    Food mapToModel(FoodDto dto);
}
