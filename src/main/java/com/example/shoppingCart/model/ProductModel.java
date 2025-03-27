package com.example.shoppingCart.model;

import com.example.shoppingCart.enums.ProductCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//@Data
public class ProductModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long productId;
    private String productName;
    private ProductCategory productCategory;
    private String productDescription;
    private Long productPrice;
    private float productRating;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public float getProductRating() {
        return productRating;
    }

    public void setProductRating(float productRating) {
        this.productRating = productRating;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
