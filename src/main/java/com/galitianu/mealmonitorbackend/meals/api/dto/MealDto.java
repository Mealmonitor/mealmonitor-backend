package com.galitianu.mealmonitorbackend.meals.api.dto;

import com.galitianu.mealmonitorbackend.common.api.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class MealDto extends BaseEntityDto {
    private ZonedDateTime dateTime;
    private List<FoodDto> foodList;
}
