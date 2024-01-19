package com.galitianu.mealmonitorbackend.users.api.dto;

import com.galitianu.mealmonitorbackend.users.persistence.entity.UserMetabolism;
import com.galitianu.mealmonitorbackend.users.persistence.entity.UserSelectedGoal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoalDto {
    private Double weight;
    private Double targetCalories, targetProteins, targetFats, targetCarbs, targetFibres;
    private UserMetabolism metabolism;
    private UserSelectedGoal selectedGoal;
}
