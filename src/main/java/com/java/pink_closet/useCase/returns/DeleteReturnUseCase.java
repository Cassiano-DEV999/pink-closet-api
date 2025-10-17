package com.java.pink_closet.useCase.returns;

import com.java.pink_closet.execeptions.returns.ReturnNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.ReturnRepository;

@Service
public class DeleteReturnUseCase {

    private final ReturnRepository returnRepository;

    public DeleteReturnUseCase(ReturnRepository returnRepository) {
        this.returnRepository = returnRepository;
    }

    public void execute(Long id) {
        var returnEntity = returnRepository.findById(id)
                .orElseThrow(() -> new ReturnNotFoundException(id));
        returnRepository.deleteById(id);
    }
}
