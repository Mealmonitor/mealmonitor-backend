package com.galitianu.mealmonitorbackend.products.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String barcode;
    private String name;
    private String brand;
    private String recommendedQuantity;
    private int caloriesPerCent;
    private float proteinsPerCent;
    private float carbsPerCent;
    private float fatsPerCent;
}
