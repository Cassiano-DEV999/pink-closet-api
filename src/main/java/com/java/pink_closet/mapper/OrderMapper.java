package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.order.request.OrderCreateRequest;
import com.java.pink_closet.dto.order.request.OrderUpdateRequest;
import com.java.pink_closet.dto.order.response.OrderDetailedResponse;
import com.java.pink_closet.dto.order.response.OrderResponse;
import com.java.pink_closet.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderCreateRequest request);
    Order toEntity(OrderUpdateRequest request);

    OrderResponse toResponse(Order entity);
    OrderDetailedResponse toDetailedResponse(Order entity);
}