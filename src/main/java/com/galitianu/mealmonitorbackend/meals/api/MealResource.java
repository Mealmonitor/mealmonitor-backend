package com.galitianu.mealmonitorbackend.meals.api;

import com.galitianu.mealmonitorbackend.common.api.BaseResource;
import com.galitianu.mealmonitorbackend.meals.api.dto.MealDto;
import com.galitianu.mealmonitorbackend.meals.mapper.FoodMapper;
import com.galitianu.mealmonitorbackend.meals.service.MealService;
import com.galitianu.mealmonitorbackend.meals.service.model.Meal;
import com.galitianu.mealmonitorbackend.users.service.UserService;
import com.galitianu.mealmonitorbackend.users.service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    private final FoodMapper foodMapper;
    private final UserService userService;

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

    @GetMapping("/{userId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<MealDto>> getMealsByDay(@RequestParam LocalDate day, @PathVariable String userId) {
        Optional<User> optionalUser = userService.getUserByFirebaseId(userId);
        if(optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Meal> meals = mealService.getMealsByDay(optionalUser.get(), day);
        meals.forEach(meal -> {meal.setUser(optionalUser.get());});
        return new ResponseEntity<>(meals.stream().map(this::createDto).toList(), HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<MealDto> createMeal(@RequestBody MealDto mealDto, @PathVariable String userId) {
        Optional<User> optionalUser = userService.getUserByFirebaseId(userId);
        if(optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Meal meal = mealService.createMeal(optionalUser.get(), mealDto.getDateTime(), mealDto.getFoodList().stream().map(foodMapper::mapToModel).toList());
        meal.setUser(optionalUser.get());
        return new ResponseEntity<>(createDto(meal), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{mealId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> deleteMeal(@PathVariable UUID mealId, @PathVariable String userId) {
        Optional<User> optionalUser = userService.getUserByFirebaseId(userId);
        if(optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Optional<Meal> meal = mealService.findById(mealId);
        if (meal.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mealService.delete(meal.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
