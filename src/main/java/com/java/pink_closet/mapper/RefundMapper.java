package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.refund.request.RefundCreateRequest;
import com.java.pink_closet.dto.refund.request.RefundUpdateRequest;
import com.java.pink_closet.dto.refund.response.RefundDetailedResponse;
import com.java.pink_closet.dto.refund.response.RefundResponse;
import com.java.pink_closet.model.Refund;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RefundMapper {
    RefundMapper INSTANCE = Mappers.getMapper(RefundMapper.class);

    Refund toEntity(RefundCreateRequest request);
    Refund toEntity(RefundUpdateRequest request);

    RefundResponse toResponse(Refund entity);
    RefundDetailedResponse toDetailedResponse(Refund entity);
}