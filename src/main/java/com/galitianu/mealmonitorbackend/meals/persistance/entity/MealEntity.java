package com.galitianu.mealmonitorbackend.meals.persistance.entity;

import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import com.galitianu.mealmonitorbackend.users.persistence.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "meal")
public class MealEntity extends BaseEntity {
    @ManyToOne
    private UserEntity user;
    private ZonedDateTime dateTime;
}
