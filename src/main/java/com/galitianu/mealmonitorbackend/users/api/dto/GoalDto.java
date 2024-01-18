package com.galitianu.mealmonitorbackend.users.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoalDto {
    private Double weight;
    private Double targetCalories, targetProteins, targetFats, targetCarbs, targetFibres;
}
