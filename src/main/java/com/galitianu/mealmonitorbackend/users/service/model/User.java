package com.galitianu.mealmonitorbackend.users.service.model;

import com.galitianu.mealmonitorbackend.common.service.BaseEntityModel;
import com.galitianu.mealmonitorbackend.users.persistence.entity.UserMetabolism;
import com.galitianu.mealmonitorbackend.users.persistence.entity.UserSelectedGoal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseEntityModel {
    private String firebaseId;
    private String firstName;
    private String lastName;
    private String email;
    private Double weight;
    private Double targetCalories, targetProteins, targetFats, targetCarbs, targetFibres;
    private UserMetabolism metabolism;
    private UserSelectedGoal selectedGoal;
}
