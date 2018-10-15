package com.cn.commodity.service;

import com.cn.commodity.entity.User;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);

}
