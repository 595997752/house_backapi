package com.team.house_backapi.controller;

import com.team.house_backapi.entity.Type;
import com.team.house_backapi.service.TypeService;
import com.team.house_backapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type/")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("getTypeData")
    public BaseResult getTypeData(){
        List<Type> list = typeService.getAllType();

        //返回一个结果对象
        return new BaseResult(200,list);

    }
}
