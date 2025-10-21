package com.java.pink_closet.controller.customer;

import com.java.pink_closet.dto.customer.response.CustomerResponse;
import com.java.pink_closet.model.Customer;
import com.java.pink_closet.useCase.customer.GetCustomerByIdUseCase;
import com.java.pink_closet.useCase.customer.ValidateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class GetCustomerController {

    private final GetCustomerByIdUseCase getCustomerByIdUseCase;
    private final ValidateCustomerUseCase validateCustomerUseCase;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id) {
        Customer existingCustomer = validateCustomerUseCase.execute(id);
        CustomerResponse customer = getCustomerByIdUseCase.execute(existingCustomer.getId());
        return ResponseEntity.ok(customer);
    }
}
