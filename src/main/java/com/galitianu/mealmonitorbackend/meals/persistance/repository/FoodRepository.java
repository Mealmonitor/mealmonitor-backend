package com.galitianu.mealmonitorbackend.meals.persistance.repository;

import com.galitianu.mealmonitorbackend.common.persistence.BaseRepository;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.MealEntity;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.FoodEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends BaseRepository<FoodEntity> {
    List<FoodEntity> getFoodsByMeal(MealEntity meal);
}
