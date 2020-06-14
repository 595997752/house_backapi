package com.team.house_backapi;

import com.team.house_backapi.entity.DistrictExample;
import com.team.house_backapi.mapper.DistrictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseBackapiApplicationTests {

    @Autowired(required = false)
    private DistrictMapper districtMapper;

    @Test
    public void contextLoads() {
        System.out.println("测试:"+districtMapper.selectByExample(new DistrictExample()).size());
    }

}
