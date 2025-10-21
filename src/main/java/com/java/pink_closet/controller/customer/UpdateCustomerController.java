package com.java.pink_closet.controller.customer;

import com.java.pink_closet.dto.customer.request.CustomerUpdateRequest;
import com.java.pink_closet.dto.customer.response.CustomerResponse;
import com.java.pink_closet.model.Customer;
import com.java.pink_closet.useCase.customer.UpdateCustomerUseCase;
import com.java.pink_closet.useCase.customer.ValidateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class UpdateCustomerController {

    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final ValidateCustomerUseCase validateCustomerUseCase;

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id,
                                                           @RequestBody CustomerUpdateRequest request) {
        Customer existingCustomer = validateCustomerUseCase.execute(id);

        CustomerResponse updatedCustomer = updateCustomerUseCase.execute(existingCustomer.getId(), request);
        return ResponseEntity.ok(updatedCustomer);
    }
}
