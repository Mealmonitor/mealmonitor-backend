package com.galitianu.mealmonitorbackend.meals.service.model;

import com.galitianu.mealmonitorbackend.common.service.BaseEntityModel;
import com.galitianu.mealmonitorbackend.users.service.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class Meal extends BaseEntityModel {
    private User user;
    private ZonedDateTime dateTime;
}
