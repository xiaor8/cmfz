package com.baizhi.service;

import com.baizhi.dto.AlbumDto;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.mapper.AlbumMapper;
import java.util.List;

import com.baizhi.mapper.ChapterMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public AlbumDto queryAll(Integer page,Integer rows) {
        RowBounds rowBounds = new RowBounds((page-1)*rows,rows);
        List<Album> albums = albumMapper.selectByRowBounds(new Album(), rowBounds);
        //根据专辑的id查询该专辑的所有章节。
        Chapter chapter = new Chapter();
        for(Album album:albums){
            chapter.setAlbumId(album.getId());
            List<Chapter> chapters = chapterMapper.select(chapter);
            album.setChildren(chapters);
        }
        int count = albumMapper.selectCount(new Album());
        AlbumDto albumDto = new AlbumDto();
        albumDto.setRows(albums);
        albumDto.setTotal(count);
        return albumDto;
    }

    @Override
    public void insertOne(Album album) {
        albumMapper.insert(album);
    }
}



