package com.team.house_backapi.controller;

import com.team.house_backapi.entity.Street;
import com.team.house_backapi.service.StreetService;
import com.team.house_backapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/street/")
public class StreetController {

    @Autowired(required = false)
    private StreetService streetService;

    @RequestMapping("getStreetData")
    public BaseResult getStreetData(Integer did){
        List<Street> list = streetService.getAllStreetByDid(did);

        return new BaseResult(200,list);
    }
}
