package com.galitianu.mealmonitorbackend.persistance.repository;

import com.galitianu.mealmonitorbackend.persistance.entity.Meal;
//import com.galitianu.mealmonitorbackend.persistance.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MealRepository extends CrudRepository<Meal, UUID> {
    List<Meal> getMealsByDateTimeIsBeforeAndDateTimeIsAfter(ZonedDateTime before, ZonedDateTime after);

}
