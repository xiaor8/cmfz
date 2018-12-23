package com.baizhi.controller;

import com.baizhi.dto.AlbumDto;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.baizhi.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @RequestMapping("queryAll")
    public AlbumDto queryAll(Integer page,Integer rows){
        AlbumDto albumDto = albumService.queryAll(page, rows);
        return albumDto;
    }

    @RequestMapping("insertOne")
    public void insertOne(Album album, MultipartFile file1) {
        FileUtil.createFile(file1,"./src/main/webapp/img/audioCollection");
        albumService.insertOne(album);
    }
}
