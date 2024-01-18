package com.galitianu.mealmonitorbackend.meals.service;

import com.galitianu.mealmonitorbackend.common.persistence.BaseRepository;
import com.galitianu.mealmonitorbackend.common.service.BaseEntityService;
import com.galitianu.mealmonitorbackend.meals.mapper.MealMapper;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.MealEntity;
import com.galitianu.mealmonitorbackend.meals.persistance.repository.MealRepository;
import com.galitianu.mealmonitorbackend.meals.service.model.Food;
import com.galitianu.mealmonitorbackend.meals.service.model.Meal;
import com.galitianu.mealmonitorbackend.users.mapper.UserMapper;
import com.galitianu.mealmonitorbackend.users.service.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class MealService extends BaseEntityService<Meal, MealEntity> {
    private final MealRepository mealRepository;
    private final MealMapper mealMapper;

    private final FoodService foodService;
    private final UserMapper userMapper;
    public List<Meal> getMealsByDay (User user, LocalDate day){
        List<MealEntity> meals = mealRepository.findAllByUser(userMapper.mapToEntity(user)); // TODO de facut prin Query
        meals = meals.stream().filter(meal -> meal.getDateTime().getMonth().equals(day.getMonth()) && meal.getDateTime().getYear() == day.getYear() && meal.getDateTime().getDayOfMonth() == day.getDayOfMonth()).toList();
        return mealMapper.mapToModels(meals);
    }

    public List<Food> getFoodList(Meal meal){
        return foodService.getFoodsByMeal(meal);
    }

    public Meal createMeal(User user, ZonedDateTime dateTime, List<Food> foodList){
        Meal meal = new Meal();
        meal.setDateTime(dateTime);
        meal.setUser(user);
        meal = save(meal);

        Meal finalMeal = meal;
        foodList.forEach(food -> {
            food.setMeal(finalMeal);
            foodService.save(food);
        });

        return meal;
    }

    @Override
    public void delete(Meal meal){
        getFoodList(meal).forEach(foodService::delete);
        super.delete(meal);
    }

    @Override
    protected BaseRepository<MealEntity> getRepository() {
        return mealRepository;
    }

    @Override
    protected MealMapper getMapper() {
        return mealMapper;
    }
}
