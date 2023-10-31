package com.galitianu.mealmonitorbackend.api;

import com.galitianu.mealmonitorbackend.persistance.entity.Meal;
import com.galitianu.mealmonitorbackend.persistance.entity.User;
import com.galitianu.mealmonitorbackend.persistance.repository.MealRepository;
import com.galitianu.mealmonitorbackend.persistance.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@RestController("/meals")
public class MealController {
    private final UserRepository userRepository;
    private final MealRepository mealRepository;

    @GetMapping()
    public ResponseEntity<List<Meal>> getMealsByUserAndDateToFrom(@RequestParam UUID userId,
                                                                  @RequestParam ZonedDateTime to,
                                                                  @RequestParam ZonedDateTime from) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Meal> meals =  mealRepository.getMealsByUserAndDateTimeIsBeforeAndDateTimeIsAfter(user.get(), from, to);
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createMeal(@RequestBody Meal meal)
    {
        mealRepository.save(meal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // TODO DTO pt creare, lista de food dto uri care se adauga la prima creare
    // TODO food repository care permite direct adaugare editare si stergere de fooduri dintrun meal
    @DeleteMapping("/{mealId}")
    public ResponseEntity<String> deleteMeal(@PathVariable UUID mealId)
    {
        Optional<Meal> meal = mealRepository.findById(mealId);
        if(meal.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mealRepository.delete(meal.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
