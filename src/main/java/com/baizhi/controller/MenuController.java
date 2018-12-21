package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/menu")
@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/queryAll")
    public List<Menu> queryAll() {
        List<Menu> menus = menuService.queryAll();
        return menus;
    }
}
