package com.galitianu.mealmonitorbackend.meals.api;

import com.galitianu.mealmonitorbackend.common.api.BaseResource;
import com.galitianu.mealmonitorbackend.meals.api.dto.NewMealDto;
import com.galitianu.mealmonitorbackend.meals.mapper.MealMapper;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.FoodEntity;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.MealEntity;
import com.galitianu.mealmonitorbackend.meals.persistance.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderion.model.ProductResponse;
import pl.coderion.service.OpenFoodFactsWrapper;
import pl.coderion.service.impl.OpenFoodFactsWrapperImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/meals")
public class MealResource extends BaseResource {
    private final MealRepository mealRepository;
    private final MealMapper mealMapper;

    @GetMapping()
    public ResponseEntity<List<MealEntity>> getMealsAndDateToFrom(@RequestParam LocalDate day) {
        List<MealEntity> meals = (List<MealEntity>) mealRepository.findAll();
        meals = meals.stream().filter(meal -> meal.getDateTime().toLocalDate().isEqual(day)).toList();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createMeal(@RequestBody NewMealDto mealDto) {
        MealEntity meal = new MealEntity();
        meal.setDateTime(mealDto.getDateTime());
        List<FoodEntity> foodList = mealDto.getFoodList().stream().map(mealMapper::fromDto).toList();
        foodList.forEach(food -> food.setMeal(meal));
        meal.setFoodList(foodList);
        mealRepository.save(meal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // TODO food repository care permite direct adaugare editare si stergere de fooduri dintrun meal
    @DeleteMapping("/{mealId}")
    public ResponseEntity<String> deleteMeal(@PathVariable UUID mealId) {
        Optional<MealEntity> meal = mealRepository.findById(mealId);
        if (meal.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mealRepository.delete(meal.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/barcode/{barCode}")
    public String getBarcodeProduct(@PathVariable String barCode)
    {
        OpenFoodFactsWrapper wrapper = new OpenFoodFactsWrapperImpl();
        ProductResponse productResponse = wrapper.fetchProductByCode(barCode);
        return productResponse.toString();
    }

}
