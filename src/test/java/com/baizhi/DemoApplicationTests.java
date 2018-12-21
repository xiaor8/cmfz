package com.baizhi;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import com.baizhi.service.BannerService;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.baizhi.mapper")
public class DemoApplicationTests {

    @Autowired
    MenuService menuService;

    @Autowired
    BannerService bannerService;
    @Test
    public void contextLoads() {
        List<Menu> menus = menuService.queryAll();
        for (Menu m : menus){
            System.out.println(m);
        }
    }

    @Test
    public void test2() {
        BannerDto bannerDto = bannerService.queryAll(2,3);
        List<Banner> rows = bannerDto.getRows();
        Integer total = bannerDto.getTotal();
        System.out.println(total);
        for(Banner b:rows){
            System.out.println(b);
        }
    }

}

