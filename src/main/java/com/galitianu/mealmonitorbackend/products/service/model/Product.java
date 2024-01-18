package com.galitianu.mealmonitorbackend.products.service.model;

import com.galitianu.mealmonitorbackend.common.service.BaseEntityModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseEntityModel {
    private String barcode;
    private String name;
    private String brand;
    private String recommendedQuantity;
    private Integer caloriesPerCent;
    private Float proteinsPerCent;
    private Float carbsPerCent;
    private Float fatsPerCent;
    private Float fibrePerCent;
}
