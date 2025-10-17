package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.product.request.ProductCreateRequest;
import com.java.pink_closet.dto.product.request.ProductUpdateRequest;
import com.java.pink_closet.dto.product.response.ProductDetailedResponse;
import com.java.pink_closet.dto.product.response.ProductResponse;
import com.java.pink_closet.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductCreateRequest request);
    Product toEntity(ProductUpdateRequest request);

    ProductResponse toResponse(Product entity);
    ProductDetailedResponse toDetailedResponse(Product entity);
}