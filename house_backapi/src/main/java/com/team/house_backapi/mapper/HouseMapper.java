package com.team.house_backapi.mapper;

import com.team.house_backapi.entity.House;
import com.team.house_backapi.entity.HouseCondition;
import com.team.house_backapi.entity.HouseExample;
import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //通过用户编号查询当前用户下的出租房
    //修改House实体，添加类型名称tname、区域名称dname、街道名称sname
    List<House> getHouseByUser(Integer userid);

    //浏览出租房
    List<House> browserHouse(HouseCondition houseCondition);
}