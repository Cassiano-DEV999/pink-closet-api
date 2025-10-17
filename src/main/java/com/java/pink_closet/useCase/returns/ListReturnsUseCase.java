package com.java.pink_closet.useCase.returns;

import com.java.pink_closet.dto.returns.response.ReturnResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import com.java.pink_closet.mapper.ReturnMapper;
import com.java.pink_closet.repositories.ReturnRepository;

@Service
public class ListReturnsUseCase {

    private final ReturnRepository returnRepository;
    private final ReturnMapper returnMapper;

    public ListReturnsUseCase(ReturnRepository returnRepository, ReturnMapper returnMapper) {
        this.returnRepository = returnRepository;
        this.returnMapper = returnMapper;
    }

    public List<ReturnResponse> execute() {
        return returnRepository.findAll()
                .stream()
                .map(returnMapper::toResponse)
                .toList();
    }
}
