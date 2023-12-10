package com.galitianu.mealmonitorbackend.products.mapper;

import com.galitianu.mealmonitorbackend.common.mapper.BaseModelEntityMapper;
import com.galitianu.mealmonitorbackend.products.api.dto.ProductDto;
import com.galitianu.mealmonitorbackend.products.persistance.entity.ProductEntity;
import com.galitianu.mealmonitorbackend.products.service.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseModelEntityMapper<Product, ProductEntity> {
    ProductDto mapToDto(Product product);
}