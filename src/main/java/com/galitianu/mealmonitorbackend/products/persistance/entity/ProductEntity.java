package com.galitianu.mealmonitorbackend.products.persistance.entity;

import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "product")
@Entity
public class ProductEntity extends BaseEntity {
    private String barcode;
    private String name;
    private String brand;
    @Column(name = "recommended_quantity")
    private String recommendedQuantity;
    @Column(name = "calories_per_cent")
    private int caloriesPerCent;
    @Column(name = "proteins_per_cent")
    private float proteinsPerCent;
    @Column(name = "carbs_per_cent")
    private float carbsPerCent;
    @Column(name = "fats_per_cent")
    private float fatsPerCent;
}
