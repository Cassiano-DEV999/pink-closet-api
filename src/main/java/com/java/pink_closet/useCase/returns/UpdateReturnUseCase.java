package com.java.pink_closet.useCase.returns;

import com.java.pink_closet.dto.returns.request.ReturnUpdateRequest;
import com.java.pink_closet.dto.returns.response.ReturnResponse;
import com.java.pink_closet.execeptions.returns.ReturnNotFoundException;
import com.java.pink_closet.mapper.ReturnMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.ReturnRepository;

@Service
public class UpdateReturnUseCase {

    private final ReturnRepository returnRepository;
    private final ReturnMapper returnMapper;

    public UpdateReturnUseCase(ReturnRepository returnRepository, ReturnMapper returnMapper) {
        this.returnRepository = returnRepository;
        this.returnMapper = returnMapper;
    }

    public ReturnResponse execute(Long id, ReturnUpdateRequest request) {
        var returnEntity = returnRepository.findById(id)
                .orElseThrow(() -> new ReturnNotFoundException(id));
        returnMapper.toEntity(request);
        returnEntity = returnRepository.save(returnEntity);
        return returnMapper.toResponse(returnEntity);
    }
}
