package com.galitianu.mealmonitorbackend.meals.service;

import com.galitianu.mealmonitorbackend.common.service.BaseEntityService;
import com.galitianu.mealmonitorbackend.meals.mapper.FoodMapper;
import com.galitianu.mealmonitorbackend.meals.mapper.MealMapper;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.FoodEntity;
import com.galitianu.mealmonitorbackend.meals.persistance.repository.FoodRepository;
import com.galitianu.mealmonitorbackend.meals.service.model.Food;
import com.galitianu.mealmonitorbackend.meals.service.model.Meal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService extends BaseEntityService<Food, FoodEntity> {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    private final MealMapper mealMapper;
    public List<Food> getFoodsByMeal(Meal meal){
        return foodMapper.mapToModels(foodRepository.getFoodsByMeal(mealMapper.mapToEntity(meal)));
    }

    @Override
    protected FoodRepository getRepository() {
        return foodRepository;
    }

    @Override
    protected FoodMapper getMapper() {
        return foodMapper;
    }
}
