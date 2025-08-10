package com.example;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

//高版本缺个包javax.xml.bind，pom里导一下

public class JwtTest {

    /**
     * 生成jwt令牌
     */
    @Test
    public void testGenerateJwt(){

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("id",1);
        objectObjectHashMap.put("username","wumingwuwuwu");
        String compact = Jwts.builder().signWith(SignatureAlgorithm.HS256, "d3VtaW5nd3V3dXd1")// 生成令牌
                .addClaims(objectObjectHashMap) // 添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置过期时间一小时))
                .compact();// 生成令牌
        System.out.println(compact);
    }

    /**
     * 解析jwt令牌
     */
    @Test
    public void testParseJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ3dW1pbmd3dXd1d3UiLCJleHAiOjE3NTQ4MzU5MzN9.EN0XWldpx0YY98hd1AZrYQxdGxqENDtSZq9WBfztrqM";
        Claims claim = Jwts.parser().setSigningKey("d3VtaW5nd3V3dXd1")
                .parseClaimsJws(token)
                .getBody();
        System.out.println( claim);

    }

}