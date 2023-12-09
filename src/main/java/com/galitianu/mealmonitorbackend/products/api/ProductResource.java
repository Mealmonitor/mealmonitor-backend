package com.galitianu.mealmonitorbackend.products.api;

import com.galitianu.mealmonitorbackend.common.api.BaseResource;
import com.galitianu.mealmonitorbackend.products.api.dto.NewProductDto;
import com.galitianu.mealmonitorbackend.products.service.ProductService;
import com.galitianu.mealmonitorbackend.products.service.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductResource extends BaseResource {
    private final ProductService productService;

    @GetMapping("/{barCode}")
    public ResponseEntity<Product> getMealsAndDateToFrom(@PathVariable String barCode) {
        return new ResponseEntity<>(productService.getProductByBarcode(barCode), HttpStatus.OK);
    }
}
