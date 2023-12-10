package com.galitianu.mealmonitorbackend.meals.service.model;

import com.galitianu.mealmonitorbackend.common.service.BaseEntityModel;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class Meal extends BaseEntityModel {
    private ZonedDateTime dateTime;
    private List<Food> foodList;
}
