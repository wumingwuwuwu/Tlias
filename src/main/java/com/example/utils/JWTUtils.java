package com.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;
import java.util.Date;

public class JWTUtils {
    private static final String SECRET_KEY = "bGl5YW5n";
    private static final long EXPIRATION_TIME = 12*60*60*1000;

    /**
     * 生成JWT令牌
     */
    public static String generateToken(Map<String, Object> claims) {

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    /**
     * 解析JWT令牌
     */
    public static Claims parseToken(String token) throws Exception {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
