package com.team.house_backapi.service.impl;

import com.team.house_backapi.entity.Street;
import com.team.house_backapi.entity.StreetExample;
import com.team.house_backapi.mapper.StreetMapper;
import com.team.house_backapi.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired(required = false)
    private StreetMapper streetMapper;

    @Override
    public List<Street> getAllStreetByDid(Integer did) {
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        List<Street> list = streetMapper.selectByExample(streetExample);
        return list;
    }
}
