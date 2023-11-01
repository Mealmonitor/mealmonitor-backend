package com.galitianu.mealmonitorbackend.api;

import com.galitianu.mealmonitorbackend.persistance.entity.Meal;
//import com.galitianu.mealmonitorbackend.persistance.entity.User;
import com.galitianu.mealmonitorbackend.persistance.repository.MealRepository;
//import com.galitianu.mealmonitorbackend.persistance.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/meals")
public class MealController {
    //    private final UserRepository userRepository;
    private final MealRepository mealRepository;

    @GetMapping()
    public ResponseEntity<List<Meal>> getMealsAndDateToFrom(@RequestParam LocalDate day) {
        List<Meal> meals = (List<Meal>) mealRepository.findAll();
        meals = meals.stream().filter(meal -> meal.getDateTime().toLocalDate().isEqual(day)).toList();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createMeal(@RequestBody Meal meal) {
        mealRepository.save(meal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // TODO DTO pt creare, lista de food dto uri care se adauga la prima creare
    // TODO food repository care permite direct adaugare editare si stergere de fooduri dintrun meal
    @DeleteMapping("/{mealId}")
    public ResponseEntity<String> deleteMeal(@PathVariable UUID mealId) {
        Optional<Meal> meal = mealRepository.findById(mealId);
        if (meal.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mealRepository.delete(meal.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
