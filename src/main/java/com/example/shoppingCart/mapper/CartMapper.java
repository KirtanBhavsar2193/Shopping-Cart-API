package com.example.shoppingCart.mapper;

import com.example.shoppingCart.entity.Cart;
import com.example.shoppingCart.model.CartModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    // Entity To Model
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "productId", ignore = true)
    CartModel cartToCartModel(Cart cart);

    // Model To Entity
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "product", ignore = true)
    Cart cartModelToCart(CartModel cartModel);

}