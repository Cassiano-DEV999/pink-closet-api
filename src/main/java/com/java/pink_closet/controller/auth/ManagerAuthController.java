package com.java.pink_closet.controller.auth;

import com.java.pink_closet.dto.auth.request.AuthLoginRequest;
import com.java.pink_closet.dto.auth.response.AuthLoginResponse;
import com.java.pink_closet.useCase.auth.AuthUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/manager")
public class ManagerAuthController {

    private final AuthUseCase authUseCase;

    public ManagerAuthController(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody AuthLoginRequest request) {
        AuthLoginResponse response = authUseCase.login(request, "manager");
        return ResponseEntity.ok(response);
    }
}
