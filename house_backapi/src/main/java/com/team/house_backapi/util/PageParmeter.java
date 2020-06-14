package com.team.house_backapi.util;

/**
 * @author 王建兵
 * @Classname PageParmeter
 * @Description TODO
 * @Date 2020/5/10 14:32
 * @Created by Administrator
 */
//分页工具类
public class PageParmeter {
    //定义分页的属性
    private Integer page=1;  //页码
    private Integer pageSize=5; //页大小

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
