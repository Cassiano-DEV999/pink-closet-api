package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.exchange.request.ExchangeCreateRequest;
import com.java.pink_closet.dto.exchange.request.ExchangeUpdateRequest;
import com.java.pink_closet.dto.exchange.response.ExchangeDetailedResponse;
import com.java.pink_closet.dto.exchange.response.ExchangeResponse;
import com.java.pink_closet.model.Exchange;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExchangeMapper {
    ExchangeMapper INSTANCE = Mappers.getMapper(ExchangeMapper.class);

    Exchange toEntity(ExchangeCreateRequest request);
    Exchange toEntity(ExchangeUpdateRequest request);

    ExchangeResponse toResponse(Exchange entity);
    ExchangeDetailedResponse toDetailedResponse(Exchange entity);
}