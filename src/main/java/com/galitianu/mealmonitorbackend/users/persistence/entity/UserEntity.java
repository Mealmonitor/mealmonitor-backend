package com.galitianu.mealmonitorbackend.users.persistence.entity;

import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mealmonitor_user")
@Getter
@Setter
public class UserEntity extends BaseEntity {
    private String firebaseId;
    private String firstName;
    private String lastName;
    private String email;
    private Double weight;
    private Double targetCalories, targetProteins, targetFats, targetCarbs, targetFibres;
    @Enumerated(EnumType.STRING)
    private UserMetabolism metabolism;
    @Enumerated(EnumType.STRING)
    private UserSelectedGoal selectedGoal;
}
