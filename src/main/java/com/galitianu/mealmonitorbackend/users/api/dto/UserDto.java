package com.galitianu.mealmonitorbackend.users.api.dto;

import com.galitianu.mealmonitorbackend.common.api.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends BaseEntityDto {
    private String firebaseId;
    private String firstName;
    private String lastName;
    private String email;
    private Double weight;
    private Double targetCalories, targetProteins, targetFats, targetCarbs, targetFibres;
}
