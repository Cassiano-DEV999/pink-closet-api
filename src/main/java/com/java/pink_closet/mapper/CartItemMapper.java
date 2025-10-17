package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.cartItem.request.CartItemCreateRequest;
import com.java.pink_closet.dto.cartItem.request.CartItemUpdateRequest;
import com.java.pink_closet.dto.cartItem.response.CartItemDetailedResponse;
import com.java.pink_closet.dto.cartItem.response.CartItemResponse;
import com.java.pink_closet.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartItemMapper {
    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    CartItem toEntity(CartItemCreateRequest request);
    CartItem toEntity(CartItemUpdateRequest request);

    CartItemResponse toResponse(CartItem entity);
    CartItemDetailedResponse toDetailedResponse(CartItem entity);
}