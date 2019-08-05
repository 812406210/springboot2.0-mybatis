package com.cn.commodity.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cn.commodity.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("tokenService")
public class TokenService {
    // 过期时间是60秒，既是1分钟
    public static final long EXPIRATION_SECOND = 60L;

    // 过期时间是3600秒，既是1个小时
    public static final long EXPIRATION = 3600L;

    // 选择了记住我之后的过期时间为7天
    public static final long EXPIRATION_REMEMBER = 604800L;


    long expiration =EXPIRATION_SECOND;
    public String getToken(User user) { //生成token
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration * 1000))//签名过期的时间
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
