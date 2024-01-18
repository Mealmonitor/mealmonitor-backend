package com.galitianu.mealmonitorbackend.products.persistance.entity;

import com.galitianu.mealmonitorbackend.common.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "product")
@Entity
@Getter
@Setter
public class ProductEntity extends BaseEntity {
    private String barcode;
    private String name;
    private String brand;
    @Column(name = "recommended_quantity")
    private String recommendedQuantity;
    @Column(name = "calories_per_cent")
    private Integer caloriesPerCent;
    @Column(name = "proteins_per_cent")
    private Float proteinsPerCent;
    @Column(name = "carbs_per_cent")
    private Float carbsPerCent;
    @Column(name = "fats_per_cent")
    private Float fatsPerCent;
    @Column(name = "fibre_per_cent")
    private Float fibrePerCent;
}
