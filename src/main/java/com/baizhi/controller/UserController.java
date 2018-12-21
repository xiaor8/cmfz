package com.baizhi.controller;

import com.baizhi.conf.ValidateImageCodeUtils;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService service;
    //查询验证码
    @RequestMapping("/getCode")
    public void getCode(HttpSession session, HttpServletResponse response){
        //获得验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //存入session
        session.setAttribute("code",securityCode);
        //获得图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        try {
            ImageIO.write( image, "png", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //登录验证
    @RequestMapping("/login")
    public String login(String phone,String password,String code,HttpSession session){

        try {
            service.login(phone,password,code,session);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "";
    }


}
