package com.team.house_backapi.service;

import com.team.house_backapi.entity.Users;

public interface UserService {

    //注册业务
    public int regUser(Users users);

    //登入
    public Users Login(String username,String password);
}
