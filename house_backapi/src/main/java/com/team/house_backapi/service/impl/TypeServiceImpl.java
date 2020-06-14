package com.team.house_backapi.service.impl;

import com.team.house_backapi.entity.Type;
import com.team.house_backapi.entity.TypeExample;
import com.team.house_backapi.mapper.TypeMapper;
import com.team.house_backapi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired(required = false)
    private TypeMapper typeMapper;


    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
