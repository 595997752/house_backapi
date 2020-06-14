package com.team.house_backapi.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author 王建兵
 * @Classname FileUploadUtil
 * @Description TODO
 * @Date 2020/2/11 11:29
 * @Created by Administrator
 */
public class FileUploadUtil {
    /**
     * 上传文件的的方法
     * @param file  表示上传的文件
     * @param path 表示上传文件的保存位置:绝对路径
     * @return 保存文件名称
     */
    public static String upload(MultipartFile file,String path) throws Exception{
        //获取上传文件名称
        String uploadFileName=file.getOriginalFilename();
        //获取上传文件的扩展名
        String expname=uploadFileName.substring(uploadFileName.lastIndexOf("."));
        //生成唯 一的名称
        String fileName=System.currentTimeMillis()+expname;
        //设置文件的保存位置
        String savePos=path+"/"+fileName;
        //创建保存文件
        File saveFile=new File(savePos);
        //上传
        file.transferTo(saveFile);
        //返回文件名称
        return fileName;
    }

}
