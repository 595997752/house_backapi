package com.team.house_backapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house_backapi.entity.House;
import com.team.house_backapi.entity.HouseCondition;
import com.team.house_backapi.mapper.HouseMapper;
import com.team.house_backapi.service.HouseService;
import com.team.house_backapi.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {

        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUser(Integer userid, PageParmeter pageParmeter) {
        //开启分页
        PageHelper.startPage(pageParmeter.getPage(),pageParmeter.getPageSize());
        //调用查询用户信息的业务
        List<House> list = houseMapper.getHouseByUser(userid);
        //把数据存入分页中
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int deleteHouse(String id, Integer delState) {
        House house=new House();
        house.setId(id);
        house.setIsdel(delState);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getBrowserHouse(HouseCondition houseCondition) {
        //开启分页
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());
        //调用浏览的方法
        List<House> list = houseMapper.browserHouse(houseCondition);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
}
