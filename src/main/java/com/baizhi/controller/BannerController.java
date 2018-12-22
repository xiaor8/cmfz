package com.baizhi.controller;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @RequestMapping("/queryAll")
    public BannerDto queryAll(Integer page,Integer rows){
        BannerDto bannerDto = bannerService.queryAll(page, rows);
        return bannerDto;
    }

    @RequestMapping("/updateOne")
    public void updateOne(Banner banner) {
        bannerService.updateOne(banner);
    }

    @RequestMapping("/insertOne")
    public void insertOne(Banner banner, MultipartFile file1) {
        //获取文件名
        String name = file1.getOriginalFilename();
        System.out.println(name);
        //重新生成文件名
        String newFileName = UUID.randomUUID()+name;
        try {
            //制定本地文件储存的路径
            File file = new File("./src/main/webapp/img");
            String canonicalPath = file.getCanonicalPath();
            //开始上传,将图片保存到制定的文件夹
            file1.transferTo(new File(canonicalPath+"/"+newFileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件上传路径获取失败");
        }

        banner.setImgPath(newFileName);
        bannerService.insertOne(banner);
    }

    @RequestMapping("/deleteOne")
    public void deleteOne(Banner banner){
        bannerService.deleteOne(banner);
    }
}
