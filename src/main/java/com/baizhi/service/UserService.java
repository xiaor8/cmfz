package com.baizhi.service;

import javax.servlet.http.HttpSession;

public interface UserService {
    //登录
    public void login(String phone, String password, String code, HttpSession session);

}
