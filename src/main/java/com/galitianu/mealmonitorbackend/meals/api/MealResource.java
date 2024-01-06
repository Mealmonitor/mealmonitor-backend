package com.galitianu.mealmonitorbackend.meals.api;

import com.galitianu.mealmonitorbackend.common.api.BaseResource;
import com.galitianu.mealmonitorbackend.meals.api.dto.MealDto;
import com.galitianu.mealmonitorbackend.meals.mapper.FoodMapper;
import com.galitianu.mealmonitorbackend.meals.mapper.MealMapper;
import com.galitianu.mealmonitorbackend.meals.service.MealService;
import com.galitianu.mealmonitorbackend.meals.service.model.Meal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/meals")
public class MealResource extends BaseResource {
    private final MealService mealService;
    private final MealMapper mealMapper;

    private final FoodMapper foodMapper;

    private MealDto createDto (Meal meal){
        MealDto dto = new MealDto();
        dto.setId(meal.getId());
        dto.setCreated(meal.getCreated());
        dto.setUpdated(meal.getUpdated());
        dto.setVersion(meal.getVersion());
        dto.setDateTime(meal.getDateTime());
        dto.setFoodList(mealService.getFoodList(meal).stream().map(foodMapper::mapToDto).toList());
        return dto;
    }

    @GetMapping()
    public ResponseEntity<List<MealDto>> getMealsByDay(@RequestParam LocalDate day) {
        List<Meal> meals = mealService.getMealsByDay(day);
        return new ResponseEntity<>(meals.stream().map(this::createDto).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MealDto> createMeal(@RequestBody MealDto mealDto) {
        Meal meal = mealService.createMeal(mealDto.getDateTime(), mealDto.getFoodList().stream().map(foodMapper::mapToModel).toList());
        return new ResponseEntity<>(createDto(meal), HttpStatus.OK);
    }

    @DeleteMapping("/{mealId}")
    public ResponseEntity<String> deleteMeal(@PathVariable UUID mealId) {
        Optional<Meal> meal = mealService.findById(mealId);
        if (meal.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mealService.delete(meal.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
