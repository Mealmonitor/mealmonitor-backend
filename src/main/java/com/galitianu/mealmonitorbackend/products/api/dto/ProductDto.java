package com.galitianu.mealmonitorbackend.products.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String barcode;
    private String name;
    private String brand;
    private String recommendedQuantity;
    private int caloriesPerCent;
    private float proteinsPerCent;
    private float carbsPerCent;
    private float fatsPerCent;
    private float fibrePerCent;

}
