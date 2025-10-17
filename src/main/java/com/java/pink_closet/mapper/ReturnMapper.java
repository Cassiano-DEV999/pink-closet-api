package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.returns.request.ReturnCreateRequest;
import com.java.pink_closet.dto.returns.request.ReturnUpdateRequest;
import com.java.pink_closet.dto.returns.response.ReturnDetailedResponse;
import com.java.pink_closet.dto.returns.response.ReturnResponse;
import com.java.pink_closet.model.Return;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReturnMapper {
    ReturnMapper INSTANCE = Mappers.getMapper(ReturnMapper.class);

    Return toEntity(ReturnCreateRequest request);
    Return toEntity(ReturnUpdateRequest request);

    ReturnResponse toResponse(Return entity);
    ReturnDetailedResponse toDetailedResponse(Return entity);
}