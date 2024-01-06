package com.galitianu.mealmonitorbackend.meals.persistance.entity;

import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "meal")
public class MealEntity extends BaseEntity {
    private ZonedDateTime dateTime;
}
