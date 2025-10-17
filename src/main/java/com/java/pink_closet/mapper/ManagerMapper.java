package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.manager.request.ManagerCreateRequest;
import com.java.pink_closet.dto.manager.request.ManagerUpdateRequest;
import com.java.pink_closet.dto.manager.response.ManagerDetailedResponse;
import com.java.pink_closet.dto.manager.response.ManagerResponse;
import com.java.pink_closet.model.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    Manager toEntity(ManagerCreateRequest request);
    Manager toEntity(ManagerUpdateRequest request);

    ManagerResponse toResponse(Manager entity);
    ManagerDetailedResponse toDetailedResponse(Manager entity);
}