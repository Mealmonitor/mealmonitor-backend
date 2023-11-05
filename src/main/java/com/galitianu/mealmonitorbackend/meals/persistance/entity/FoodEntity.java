package com.galitianu.mealmonitorbackend.meals.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "food")
public class FoodEntity extends BaseEntity {
    @ManyToOne
    @JsonIgnore
    private MealEntity meal;
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
