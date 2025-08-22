package com.deliverytech.delivery.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.deliverytech.delivery.models.Usuarios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
    private final String SECRET_KEY = "FyC4HEPFSAKVT5oNzmmMcp6O6Yu58dAkFxiQ4GaAhn9Cj5gQWTbEtrym7cE5rdsl"; // 64 Caracteres

    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }
     public Claims extractAllClaims(String token){
        return Jwts
            .parserBuilder()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
     }

     private Key getSignKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
     }

     public String generateToken(UserDetails userDetails, Usuarios usuario){
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", usuario.getId());
        claims.put("role", usuario.getRole());
        claims.put("restauranteId", usuario.getRestauranteId());

        return createToken(claims, userDetails.getUsername());
     }

     private String createToken(Map<String, Object> claims, String subject) {
        long expiration = 1000 * 60 * 60 * 24; // Milisegundos (um dia)
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
     

}