package com.cn.commodity.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cn.commodity.entity.User;
import org.springframework.stereotype.Service;

@Service("tokenService")
public class TokenService {

    public String getToken(User user) { //生成token
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
