package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.orderItem.request.OrderItemCreateRequest;
import com.java.pink_closet.dto.orderItem.request.OrderItemUpdateRequest;
import com.java.pink_closet.dto.orderItem.response.OrderItemDetailedResponse;
import com.java.pink_closet.dto.orderItem.response.OrderItemResponse;
import com.java.pink_closet.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItem toEntity(OrderItemCreateRequest request);
    OrderItem toEntity(OrderItemUpdateRequest request);

    OrderItemResponse toResponse(OrderItem entity);
    OrderItemDetailedResponse toDetailedResponse(OrderItem entity);
}