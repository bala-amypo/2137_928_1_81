package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expiration = 1000 * 60 * 60; // 1 hour

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(User user) {
        return generateToken(Map.of(
                "email", user.getEmail(),
                "role", user.getRole(),
                "userId", user.getId()
        ), user.getEmail());
    }

    public Claims parseToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) { return parseToken(token).getSubject(); }
    public String extractRole(String token) { return (String) parseToken(token).get("role"); }
    public Long extractUserId(String token) { return ((Number) parseToken(token).get("userId")).longValue(); }
    public boolean isTokenValid(String token, String username) { return extractUsername(token).equals(username); }
}
