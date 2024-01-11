package com.galitianu.mealmonitorbackend.users.persistence.entity;

import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mealmonitor_user")
@Getter
@Setter
public class UserEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean gender;
    private Double weight;
    private Double targetCalories, targetProteins, targetFats, targetFibres;
}
