package com.galitianu.mealmonitorbackend.products.service;

import com.galitianu.mealmonitorbackend.common.service.BaseService;
import com.galitianu.mealmonitorbackend.products.mapper.ProductMapper;
import com.galitianu.mealmonitorbackend.products.persistance.entity.ProductEntity;
import com.galitianu.mealmonitorbackend.products.persistance.repository.ProductRepository;
import com.galitianu.mealmonitorbackend.products.service.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderion.model.ProductResponse;
import pl.coderion.service.OpenFoodFactsWrapper;
import pl.coderion.service.impl.OpenFoodFactsWrapperImpl;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService extends BaseService {
    private final OpenFoodFactsWrapper wrapper = new OpenFoodFactsWrapperImpl();
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Product getProductByBarcode(String barcode)
    {
        Optional<ProductEntity> localProduct = productRepository.findByBarcode(barcode);
        if(localProduct.isEmpty())
        {
            ProductResponse productResponse = wrapper.fetchProductByCode(barcode);
            Product product = new Product();
            product.setBarcode(barcode);
            product.setName(productResponse.getProduct().getProductName());
            product.setBrand(productResponse.getProduct().getBrands());
            product.setRecommendedQuantity(productResponse.getProduct().getQuantity());
            product.setFatsPerCent(productResponse.getProduct().getNutriments().getFat100G());
            product.setCarbsPerCent(productResponse.getProduct().getNutriments().getCarbohydrates100G());
            product.setProteinsPerCent(productResponse.getProduct().getNutriments().getProteins100G());
            product.setCaloriesPerCent(productResponse.getProduct().getNutriments().getEnergyKcal100G());
            return product;
        }
        else
            return productMapper.toModel(localProduct.get());

    }

//    public List<Product> getProductsBySearch(String query)
//    {
//
//    }
//
//    public void saveProductFromFood(Food food)
//    {
//
//    }
}
