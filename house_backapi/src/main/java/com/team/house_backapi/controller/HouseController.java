package com.team.house_backapi.controller;

import com.github.pagehelper.PageInfo;
import com.team.house_backapi.entity.House;
import com.team.house_backapi.entity.HouseCondition;
import com.team.house_backapi.entity.Users;
import com.team.house_backapi.service.HouseService;
import com.team.house_backapi.util.BaseResult;
import com.team.house_backapi.util.FileUploadUtil;
import com.team.house_backapi.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/house/")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("fabuhouse")
    public BaseResult fabuhouse(House house,
                                HttpSession session,
                                @RequestParam(value = "pfile",required = false)
                                MultipartFile pfile) {


        // System.out.println("用户编号："+users.getId());
       try {
            //一、实现文件上传
            //注意：a.将上传的文件保存到文件服务器中(d://images充当文件服务器)
            //     b.一个上传的文件域对应一个MultipartFile类的对象
            String path="D://xxw";
            String fileName = FileUploadUtil.upload(pfile, path);
            System.out.println("保存成功");
            //设置session //设置当前所属的用户编号(获取session信息)
            Users users=(Users)session.getAttribute("logininfo");
            house.setUserId(users.getId()); //设置用户编

            //二、将输入的出租房信息保存到数据库
            //设置出租房的随机唯一编号(采用时间毫秒)
            house.setId(System.currentTimeMillis()+"");
            //设置上传文件路径
            house.setPath(fileName);

            //调用业务保存信息
            houseService.addHouse(house);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BaseResult(BaseResult.RESULT_SUCCESS,"");

    }

    //获取用户出租房信息  传递页码page
    @RequestMapping("getHouseByPage")
    public BaseResult getHouseByPage(PageParmeter pageParmeter,HttpSession session){
        //调用业务获取分页信息
        //假如登入没有实现，获取不到session时，固定用户编号
        Users users= (Users)session.getAttribute("logininfo");
        PageInfo<House> pageInfo = houseService.getHouseByUser(users.getId(), pageParmeter);

        //只需要两个i信息，所以创建一个map集合存放
        Map<String,Object> map=new HashMap<>();
        map.put("totalPage",pageInfo.getPages());//页大小
        map.put("row",pageInfo.getList());//当前页的数据
        return new BaseResult(200,map);
    }
    //逻辑删除房屋的信息
    @RequestMapping("deleteHouse")
    public BaseResult deleteHouse(String id){
        //调用删除的业务
        int i = houseService.deleteHouse(id, 1);
        if (i>0){//表示成功
            return new BaseResult(BaseResult.RESULT_SUCCESS);
        }else {//表示失败
            return new BaseResult(BaseResult.RESULT_FAIL);
        }
    }

    //浏览出租房  houseCondition接收前端所有的数据
    @RequestMapping("searchHouse")
    public BaseResult searchHouse(HouseCondition houseCondition){
        //调用浏览的业务
        PageInfo<House> pageInfo = houseService.getBrowserHouse(houseCondition);
        Map<String,Object> map=new HashMap<>();
        map.put("totalPage",pageInfo.getPages());
        map.put("curPage",pageInfo.getPageNum());
        map.put("list",pageInfo.getList());
        return new BaseResult(200,map) ;
    }
}
