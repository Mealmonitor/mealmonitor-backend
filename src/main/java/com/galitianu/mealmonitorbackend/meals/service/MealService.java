package com.galitianu.mealmonitorbackend.meals.service;

import com.galitianu.mealmonitorbackend.common.persistence.BaseRepository;
import com.galitianu.mealmonitorbackend.common.service.BaseEntityService;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.MealEntity;
import com.galitianu.mealmonitorbackend.meals.persistance.repository.MealRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class MealService extends BaseEntityService<MealEntity> {
    private final MealRepository mealRepository;



    @Override
    protected BaseRepository<MealEntity> getRepository() {
        return mealRepository;
    }
}
