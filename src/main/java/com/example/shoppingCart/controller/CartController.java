package com.example.shoppingCart.controller;

import com.example.shoppingCart.mapper.CartMapper;
import com.example.shoppingCart.model.CartModel;
import com.example.shoppingCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartMapper cartMapper;


    @PostMapping("/addToCart/{userId}")
    public List<CartModel> addMultipleToCart(@PathVariable Long userId, @RequestBody CartModel cartModels) {
        return cartService.addProductToCart(userId, cartModels);
    }


    @DeleteMapping("/deleteItemFromCart/{userId}/{productId}")
    public ResponseEntity removeFromCart(@PathVariable Long userId, @PathVariable List<Long> productId){
        cartService.removeItem(userId, productId);
        return ResponseEntity.ok("Item Deleted Successfully From Your Cart");
    }

}