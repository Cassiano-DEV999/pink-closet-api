package com.java.pink_closet.controller.customer;

import com.java.pink_closet.dto.customer.request.CustomerCreateRequest;
import com.java.pink_closet.dto.customer.response.CustomerResponse;
import com.java.pink_closet.useCase.customer.CreateCustomerUseCase;
import com.java.pink_closet.useCase.customer.ValidateCustomerRegistrationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CreateCustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final ValidateCustomerRegistrationUseCase validateCustomerRegistrationUseCase;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerCreateRequest request) {
        validateCustomerRegistrationUseCase.execute(request);

        CustomerResponse savedCustomer = createCustomerUseCase.execute(request);
        return ResponseEntity.ok(savedCustomer);
    }
}
