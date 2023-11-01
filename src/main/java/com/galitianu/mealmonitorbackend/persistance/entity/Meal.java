package com.galitianu.mealmonitorbackend.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "meal")
public class Meal extends BaseEntity{
    private ZonedDateTime dateTime;
//    @ManyToOne
//    private User user;
    @OneToMany(mappedBy = "meal", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Food> foodList;
}
