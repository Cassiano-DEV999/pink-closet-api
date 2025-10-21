package com.java.pink_closet.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String userId, String type, String name, String email) {
        return Jwts.builder()
                .setSubject(userId)
                .addClaims(Map.of(
                        "type", type,
                        "name", name,
                        "email", email
                ))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUserId(String token) {
        return getClaims(token).getSubject();
    }

    public String getUserType(String token) {
        return getClaims(token).get("type", String.class);
    }

    public String getUserName(String token) {
        return getClaims(token).get("name", String.class);
    }

    public String getUserEmail(String token) {
        return getClaims(token).get("email", String.class);
    }
}
