package com.java.pink_closet.controller.customer;

import com.java.pink_closet.model.Customer;
import com.java.pink_closet.useCase.customer.DeleteCustomerUseCase;
import com.java.pink_closet.useCase.customer.ValidateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class DeleteCustomerController {

    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final ValidateCustomerUseCase validateCustomerUseCase;

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Customer existingCustomer = validateCustomerUseCase.execute(id);

        deleteCustomerUseCase.execute(existingCustomer.getId());
        return ResponseEntity.noContent().build();
    }
}
