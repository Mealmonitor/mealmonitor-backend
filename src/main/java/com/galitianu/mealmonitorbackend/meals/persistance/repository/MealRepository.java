package com.galitianu.mealmonitorbackend.meals.persistance.repository;

import com.galitianu.mealmonitorbackend.common.persistence.BaseRepository;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.MealEntity;
//import com.galitianu.mealmonitorbackend.persistance.entity.User;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface MealRepository extends BaseRepository<MealEntity> {
    List<MealEntity> getMealsByDateTimeIsBeforeAndDateTimeIsAfter(ZonedDateTime before, ZonedDateTime after);

}
