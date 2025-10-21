package com.java.pink_closet.useCase.auth;

import com.java.pink_closet.dto.auth.request.AuthLoginRequest;
import com.java.pink_closet.dto.auth.response.AuthLoginResponse;
import com.java.pink_closet.security.AppUserDetails;
import com.java.pink_closet.security.AppUserDetailsService;
import com.java.pink_closet.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUseCase {

    private final AppUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthLoginResponse login(AuthLoginRequest request, String userType) {
        var userDetails = (AppUserDetails) userDetailsService.loadUserByUsername(request.getEmail());

        if (!passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }

        String token = jwtProvider.generateToken(
                userDetails.getId().toString(),
                userDetails.getType(),
                userDetails.getName(),
                userDetails.getEmail()
        );

        return new AuthLoginResponse(token);
    }
}
