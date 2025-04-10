package com.example.shoppingCart.controller;

import com.example.shoppingCart.model.ProductModel;
import com.example.shoppingCart.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name = "Product", description = "Shopping Cart Operations")
@RequestMapping("/shopkeeper")
public class ProductController {

    @Autowired
    private ProductService productService;


    // Adding The Product
    @PostMapping("/insert")
    public ResponseEntity<ProductModel> saveProduct(@Valid @RequestBody ProductModel productModel){
        return new ResponseEntity<>(productService.addProduct(productModel), HttpStatus.OK);
    }


    // Getting All Products
    @GetMapping("/listAll")
    public ResponseEntity<List<ProductModel>> listAll(){
        return ResponseEntity.ok(productService.fetchProducts());
    }


    // Get Product By ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductModel> getById(@PathVariable Long id) {
        ProductModel productModel = productService.findProductById(id);
        if (productModel != null) {
            return ResponseEntity.ok(productModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Delete Product By ID
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean product = productService.deleteProductById(id);
        if (product) {
            return ResponseEntity.ok("Product deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }


    // Update Product By ID
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel productModel) {
        return ResponseEntity.ok(productService.updateProduct(id, productModel));
    }


    @GetMapping("/search")
    public List<ProductModel> searchProducts(@RequestParam(required = false) String search) {
        return productService.searchProducts(search);
    }

}