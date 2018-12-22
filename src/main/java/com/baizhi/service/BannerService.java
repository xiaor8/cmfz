package com.baizhi.service;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;

public interface BannerService {
    //查看轮播图
    public BannerDto queryAll(Integer page,Integer rows);
    //修改轮播图
    public void updateOne(Banner banner);
    //添加轮播图
    public void insertOne(Banner banner);
    //删除轮播图
    public void deleteOne(Banner banner);
}
