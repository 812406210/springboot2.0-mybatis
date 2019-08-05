package com.cn.commodity.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.commodity.annotations.PassToken;
import com.cn.commodity.annotations.UserLoginToken;
import com.cn.commodity.dao.UserDao;
import com.cn.commodity.entity.User;
import com.cn.commodity.service.TokenService;
import com.cn.commodity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api")
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @Resource
    private UserDao userDao;
    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        //User userForBase=userService.getUserById(user.getId());
        User userForBase=userDao.selectOne(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    @PassToken
    @GetMapping("/skipToken")
    public String skipToken(){
        return "跳过passToken认证";
    }
}