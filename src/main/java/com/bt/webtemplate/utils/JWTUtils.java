/**
* @Author: xiekun
* @Date: 2023-04-19
* @Description: 
*/
package com.bt.webtemplate.utils;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtils {
    public static final String key = "kevinxie";

    public static String generateToken(long userId) {
        return JWT.create()
                .withClaim("uid", userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 3600))
                .sign(Algorithm.HMAC256(key));
    }

    public static long validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getClaim("uid").asLong();
    }
}