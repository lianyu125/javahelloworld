package com.zou.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.*;

//登陆servlet
@Controller
@RequestMapping("/")
public class LoginCotroller {

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public void login(HttpServletRequest req, HttpServletResponse response)throws ServletException, IOException {

       String userName = (String) req.getParameter("uname");
        String passWord = (String) req.getParameter("upwd");
        String nickName = (String) req.getParameter("nkname");

        System.out.println("请求的userName为" + userName + "\n请求的passWord为" + passWord + "\n请求的nickName为" + nickName);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
       try{
            out.println("{\"dfjkf\":\"dfdfd\",\"ererr\":\"dsdsds\"}");
       }finally {

       }

    }


    @RequestMapping(value = "viewAll")
    public ModelAndView viewAll(String name, String pwd) {
        ModelAndView mv = new ModelAndView();
        System.out.println("进入了控制器viewAll方法");
        System.out.println("name:"+name +"\npwd:"+pwd);
        mv.setViewName("/hello");
        return mv;

    }



}
