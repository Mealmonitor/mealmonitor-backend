package com.galitianu.mealmonitorbackend.meals.persistance.entity;

import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "meal")
public class MealEntity extends BaseEntity {
    private ZonedDateTime dateTime;
//    @ManyToOne
//    private User user;
    @OneToMany(mappedBy = "meal", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodEntity> foodList;
}
