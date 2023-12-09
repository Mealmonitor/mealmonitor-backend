package com.galitianu.mealmonitorbackend.products.mapper;

import com.galitianu.mealmonitorbackend.meals.api.dto.NewFoodDto;
import com.galitianu.mealmonitorbackend.meals.persistance.entity.FoodEntity;
import com.galitianu.mealmonitorbackend.products.persistance.entity.ProductEntity;
import com.galitianu.mealmonitorbackend.products.service.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toModel(ProductEntity entity);
}
