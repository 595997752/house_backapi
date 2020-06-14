package com.team.house_backapi.controller;

import com.team.house_backapi.entity.Users;
import com.team.house_backapi.service.UserService;
import com.team.house_backapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("regUser")
    public BaseResult regUser(Users users){
        //调用业务
        int i = userService.regUser(users);
        if (i>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"出错了");
        }

    }

    @RequestMapping("userLogin")
    public BaseResult userLogin(String username, String password, HttpSession session) {
        Users users = userService.Login(username, password);
        if (users!=null) {
              session.setAttribute("logininfo",users);
              //保存存活时间
            session.setMaxInactiveInterval(600);
              return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"用户名或密码不正确！");
        }
    }
}
