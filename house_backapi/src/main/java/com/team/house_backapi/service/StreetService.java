package com.team.house_backapi.service;

import com.team.house_backapi.entity.Street;

import java.util.List;

public interface StreetService {

    //通过区域did获取所有街道
    public List<Street> getAllStreetByDid(Integer did);
}
