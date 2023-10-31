package com.galitianu.mealmonitorbackend.persistance.repository;

import com.galitianu.mealmonitorbackend.persistance.entity.Food;
import com.galitianu.mealmonitorbackend.persistance.entity.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodRepository extends CrudRepository<Food, UUID> {
    List<Food> getFoodsByMeal(Meal meal);
}
