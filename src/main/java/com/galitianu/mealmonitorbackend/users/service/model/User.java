package com.galitianu.mealmonitorbackend.users.service.model;

import com.galitianu.mealmonitorbackend.common.service.BaseEntityModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseEntityModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean gender;
    private Double weight;
    private Double targetCalories, targetProteins, targetFats, targetFibres;
}
