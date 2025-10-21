package com.java.pink_closet.controller.auth;

import com.java.pink_closet.dto.auth.response.AuthLoginResponse;
import com.java.pink_closet.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class RefreshTokenController {

    private final JwtProvider jwtProvider;

    // Endpoint POST /auth/refresh-token
    @PostMapping("/refresh-token")
    public ResponseEntity<AuthLoginResponse> refreshToken(
            @RequestHeader("Authorization") String tokenHeader) {

        if (tokenHeader == null || !tokenHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        String token = tokenHeader.replace("Bearer ", "");

        if (!jwtProvider.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Date expiration = jwtProvider.getClaims(token).getExpiration();
        long millisLeft = expiration.getTime() - System.currentTimeMillis();
        long THREE_HOURS = 3 * 60 * 60 * 1000; // 3h em milissegundos

        String newToken = token;
        if (millisLeft < THREE_HOURS) {
            // Gera um novo token com 24h de validade
            newToken = jwtProvider.generateToken(
                    jwtProvider.getUserId(token),
                    jwtProvider.getUserType(token),
                    jwtProvider.getUserName(token),
                    jwtProvider.getUserEmail(token)
            );
        }

        return ResponseEntity.ok(new AuthLoginResponse(newToken));
    }
}
