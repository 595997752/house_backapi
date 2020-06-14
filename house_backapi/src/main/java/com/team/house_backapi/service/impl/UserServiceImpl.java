package com.team.house_backapi.service.impl;

import com.team.house_backapi.entity.Users;
import com.team.house_backapi.entity.UsersExample;
import com.team.house_backapi.mapper.UsersMapper;
import com.team.house_backapi.service.UserService;
import com.team.house_backapi.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UsersMapper usersMapper;

    @Override
    public int regUser(Users users) {
        //密码不要以明文方式保存到数据中，这样做不安全
        //使用md5工具类对密码进行加密后存储到数据库
        //使用步骤:1.导入md5工具类  2.调用md5工具类的方法进行加密
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override//登入的密码加密后再进行数据库比对
    public Users Login(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(username);
        //登入的密码加密后再进行数据库比对
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list!=null&&list.size()==1){
            return list.get(0);
        }
        return null;
    }
}
