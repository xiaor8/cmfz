package com.baizhi.service;

import com.baizhi.dto.AlbumDto;
import com.baizhi.entity.Album;

public interface AlbumService {
    //查询所有的专辑
    public AlbumDto queryAll(Integer page,Integer rows);
    //添加一个专辑
    public void insertOne(Album album);
}
