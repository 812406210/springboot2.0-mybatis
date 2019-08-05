package com.cn.commodity.controller;

import com.cn.commodity.dao.UserDao;
import com.cn.commodity.entity.User;
import com.cn.commodity.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("")

public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private UserDao userDao;

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public void addUser(HttpServletRequest request){
        for(int i=0;i<10000;i++ ){
            User user = new User();
            user.setId(i+1);
            user.setAge(i);
            user.setUserName("yangwj"+i);
            user.setPassword("wj"+i);
            userService.addUser(user);
        }
        return ;
    }

    @RequestMapping("/mybatisPlus")
    @ResponseBody
    public  PageInfo<User> mybatisPlus(@RequestParam int pageNum,
                                       @RequestParam int pageSize,
                                       HttpServletRequest request){
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList =  userDao.selectList(null);
        PageInfo<User> pageInfo = new PageInfo(userList);
        System.out.println(userList);
        return pageInfo;
    }
}