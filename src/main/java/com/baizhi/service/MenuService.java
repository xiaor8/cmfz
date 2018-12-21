package com.baizhi.service;

import com.baizhi.entity.Menu;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface MenuService {
    //查询所有的类别、
    public List<Menu> queryAll();
}
