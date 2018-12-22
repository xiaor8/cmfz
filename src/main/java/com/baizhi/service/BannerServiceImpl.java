package com.baizhi.service;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public BannerDto queryAll(Integer page,Integer rows) {
        RowBounds rowBounds = new RowBounds((page-1)*rows,rows);
        List<Banner> banners = bannerMapper.selectByRowBounds(new Banner(), rowBounds);
        int count = bannerMapper.selectCount(new Banner());
        BannerDto bannerDto = new BannerDto();
        bannerDto.setRows(banners);
        bannerDto.setTotal(count);
        return bannerDto;
    }

    @Override
    public void updateOne(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public void insertOne(Banner banner) {
        banner.setPubDate(new Date());
        banner.setStatus("N");
        bannerMapper.insert(banner);
    }

    @Override
    public void deleteOne(Banner banner) {
        String imgPath = banner.getImgPath();
        File file = new File("./src/main/webapp/img/" + imgPath);
        //删除本地的图片文件
        file.delete();
        //删除数据库中该轮播图的记录
        bannerMapper.deleteByPrimaryKey(banner);
    }
}
