package com.java.pink_closet.controller.auth;

import com.java.pink_closet.dto.auth.request.AuthLoginRequest;
import com.java.pink_closet.dto.auth.response.AuthLoginResponse;
import com.java.pink_closet.useCase.auth.AuthUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/customer")
public class CustomerAuthController {

    private final AuthUseCase authUseCase;

    public CustomerAuthController(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody AuthLoginRequest request) {
        AuthLoginResponse response = authUseCase.login(request, "customer");
        return ResponseEntity.ok(response);
    }
}
