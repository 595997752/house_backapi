package com.team.house_backapi.service;

import com.github.pagehelper.PageInfo;
import com.team.house_backapi.entity.House;
import com.team.house_backapi.entity.HouseCondition;
import com.team.house_backapi.util.PageParmeter;

public interface HouseService {

    //发布房屋信息
    public int addHouse(House house);

    //查询当前用户的房屋信息
    /**
     * 查询某用户下的出租房
     * @param userid  用户编号
     * @param pageParmeter  分页的参数，页码，页大小
     * @return
     */

    public PageInfo<House> getHouseByUser(Integer userid, PageParmeter pageParmeter);

    /**
     * 删除出租房|恢复出租房
     * @param id
     * @param delState 1 表示删除   0表示恢复
     * @return
     */
    public int deleteHouse(String id,Integer delState);

    /**
     * 搜索浏览出租房
     * @param houseCondition  搜索条件
     * @return 返回搜索的出租房
     */
    public PageInfo<House> getBrowserHouse(HouseCondition houseCondition);
}
