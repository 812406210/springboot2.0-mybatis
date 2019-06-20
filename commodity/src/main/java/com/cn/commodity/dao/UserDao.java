package com.cn.commodity.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cn.commodity.entity.User;

public interface UserDao  extends BaseMapper<User> {
    int deleteByPrimaryKey(Integer id);

    Integer insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}