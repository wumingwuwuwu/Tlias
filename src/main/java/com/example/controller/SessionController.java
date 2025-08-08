package com.example.controller;

import com.example.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {

    //设置Cookie
//    @GetMapping("/c1")
//    public Result cookie1(HttpServletResponse response){
//        response.addCookie(new Cookie("login_username","itheima")); //设置Cookie/响应Cookie
//        return Result.success();
//    }
//
//    //获取Cookie
//    @GetMapping("/c2")
//    public Result cookie2(HttpServletRequest request){
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if(cookie.getName().equals("login_username")){
//                System.out.println("login_username: "+cookie.getValue()); //输出name为login_username的cookie
//            }
//        }
//        return Result.success();
//    }

    /**
     * 处理/session1请求，用于演示Session的基本用法
     * 往Session中存储用户登录信息
     * 
     * @param session HttpSession对象，由Spring自动注入
     * @return 统一响应结果对象，表示操作成功
     */
    @GetMapping("/s1")
    public Result session1(HttpSession session){
        log.info("HttpSession-s1: {}", session.hashCode());

        session.setAttribute("loginUser", "tom"); //往session中存储数据
        return Result.success();
    }

    /**
     * 处理/s2请求，用于从Session中获取用户登录信息
     * 演示如何从Session中检索之前存储的数据
     * 
     * @param request HttpServletRequest对象，用于获取Session
     * @return 统一响应结果对象，包含从Session中获取的用户信息
     */
    @GetMapping("/s2")
    public Result session2(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("HttpSession-s2: {}", session.hashCode());

        Object loginUser = session.getAttribute("loginUser"); //从session中获取数据
        log.info("loginUser: {}", loginUser);
        return Result.success(loginUser);
    }
}