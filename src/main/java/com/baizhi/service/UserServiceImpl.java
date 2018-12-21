package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void login(String phone, String password, String code, HttpSession session) {
        //验证码错误
        String code1 = (String)session.getAttribute("code");
        System.out.println(code1+"-----"+code);
        if(!code1.toUpperCase().equals(code.toUpperCase())){
            throw new RuntimeException("验证码错误");
        }

        User user1 = new User();
        user1.setPhone(phone);
        user1.setPassword(password);
        User user = userMapper.selectOne(user1);
        if(user==null){
            throw new RuntimeException("账号不存在或密码错误");
        }
    }


}
