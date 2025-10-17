package com.java.pink_closet.useCase.returns;

import com.java.pink_closet.dto.returns.request.ReturnCreateRequest;
import com.java.pink_closet.dto.returns.response.ReturnResponse;
import com.java.pink_closet.execeptions.orderItem.OrderItemNotFoundException;
import com.java.pink_closet.mapper.ReturnMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.ReturnRepository;
import com.java.pink_closet.repositories.OrderItemRepository;

@Service
public class CreateReturnUseCase {

    private final ReturnRepository returnRepository;
    private final OrderItemRepository orderItemRepository;
    private final ReturnMapper returnMapper;

    public CreateReturnUseCase(ReturnRepository returnRepository, OrderItemRepository orderItemRepository, ReturnMapper returnMapper) {
        this.returnRepository = returnRepository;
        this.orderItemRepository = orderItemRepository;
        this.returnMapper = returnMapper;
    }

    public ReturnResponse execute(ReturnCreateRequest request) {
        var orderItem = orderItemRepository.findById(request.getOrderItemId())
                .orElseThrow(() -> new OrderItemNotFoundException(request.getOrderItemId()));

        var returnEntity = returnMapper.toEntity(request); // ReturnRequest + OrderItem -> Return
        returnEntity = returnRepository.save(returnEntity);
        return returnMapper.toResponse(returnEntity);
    }
}
