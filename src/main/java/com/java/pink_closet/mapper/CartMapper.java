package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.cart.request.CartCreateRequest;
import com.java.pink_closet.dto.cart.request.CartUpdateRequest;
import com.java.pink_closet.dto.cart.response.CartDetailedResponse;
import com.java.pink_closet.dto.cart.response.CartResponse;
import com.java.pink_closet.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    Cart toEntity(CartCreateRequest request);
    Cart toEntity(CartUpdateRequest request);

    CartResponse toResponse(Cart entity);
    CartDetailedResponse toDetailedResponse(Cart entity);
}