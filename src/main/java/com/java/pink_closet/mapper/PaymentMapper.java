package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.payment.request.PaymentCreateRequest;
import com.java.pink_closet.dto.payment.request.PaymentUpdateRequest;
import com.java.pink_closet.dto.payment.response.PaymentDetailedResponse;
import com.java.pink_closet.dto.payment.response.PaymentResponse;
import com.java.pink_closet.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment toEntity(PaymentCreateRequest request);
    Payment toEntity(PaymentUpdateRequest request);

    PaymentResponse toResponse(Payment entity);
    PaymentDetailedResponse toDetailedResponse(Payment entity);
}


