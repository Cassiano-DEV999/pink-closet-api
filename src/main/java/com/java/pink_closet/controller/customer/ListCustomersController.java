package com.java.pink_closet.controller.customer;

import com.java.pink_closet.dto.customer.response.CustomerResponse;
import com.java.pink_closet.useCase.customer.ListCustomersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class ListCustomersController {

    private final ListCustomersUseCase listCustomersUseCase;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CustomerResponse>> listCustomers() {
        List<CustomerResponse> customers = listCustomersUseCase.execute();
        return ResponseEntity.ok(customers);
    }
}
