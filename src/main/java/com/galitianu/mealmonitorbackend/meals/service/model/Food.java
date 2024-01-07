package com.galitianu.mealmonitorbackend.meals.service.model;

import com.galitianu.mealmonitorbackend.common.service.BaseEntityModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food extends BaseEntityModel {
    private Meal meal;
    private String barCode;
    private String name;
    private String brand;
    private String unitOfMeasurement;
    private Long quantity;
    private Long calories;
    private Long proteins;
    private Long carbs;
    private Long fats;
    private Long fibre;
}
