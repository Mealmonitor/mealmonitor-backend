package com.galitianu.mealmonitorbackend.products.persistance.repository;

import com.galitianu.mealmonitorbackend.common.persistence.BaseRepository;
import com.galitianu.mealmonitorbackend.products.persistance.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity> {
    Optional<ProductEntity> findByBarcode(String barcode);
}
