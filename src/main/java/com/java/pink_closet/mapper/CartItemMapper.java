package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.cartItem.request.CartItemCreateRequest;
import com.java.pink_closet.dto.cartItem.request.CartItemUpdateRequest;
import com.java.pink_closet.dto.cartItem.response.CartItemDetailedResponse;
import com.java.pink_closet.dto.cartItem.response.CartItemResponse;
import com.java.pink_closet.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartItemMapper {
    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    @Mapping(target = "product", ignore = true)
    @Mapping(target = "cart", ignore = true)
    @Mapping(target = "id", ignore = true) // IDs são gerados pelo banco
    @Mapping(target = "subtotal", ignore = true) // Subtotal deve ser calculado
    @Mapping(target = "selected", ignore = true) // Valor padrão
    CartItem toEntity(CartItemCreateRequest request);

    @Mapping(target = "product", ignore = true)
    @Mapping(target = "cart", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subtotal", ignore = true)
    @Mapping(target = "selected", ignore = true)
    CartItem toEntity(CartItemUpdateRequest request);

    @Mapping(source = "product.id", target = "productId")
    CartItemResponse toResponse(CartItem entity);

    @Mappings({
            @Mapping(source = "cart.id", target = "cartId"),
            @Mapping(source = "product.id", target = "productId"),
            @Mapping(source = "product.name", target = "productName"),
            @Mapping(source = "product.price", target = "productPrice")
    })
    CartItemDetailedResponse toDetailedResponse(CartItem entity);
}