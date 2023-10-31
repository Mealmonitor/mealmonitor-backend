package com.galitianu.mealmonitorbackend.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "food")
public class Food extends BaseEntity{
    @ManyToOne
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
}
