package com.wang.store.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wang.store.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WHQ
 * @Date: 2019/5/4 10:38
 */
@Service
public class JWTService {

    public String createToken(User user) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        int a = user.getId();
        System.out.println(a);
        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("name", user.getName())//payload
                .withClaim("userid",String.valueOf(a))
                .sign(Algorithm.HMAC256("secret"));//加密
        return token;
    }

    public int verifyToken(String token) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("name").asString());
        System.out.println(claims.get("userid").asString());
        int id = Integer.parseInt(claims.get("userid").asString());
        return id;
    }

}
