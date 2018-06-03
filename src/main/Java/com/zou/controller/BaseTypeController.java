package com.zou.controller;

import com.zou.model.User;
import com.zou.model.UserListForm;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller

public class BaseTypeController {

    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(@RequestParam int age) {
        return "age:"+ age;

    }

    //数组
    //todo http://localhost:8080/array.do?name=1234&name=Jack&name=dfafjafjak&name=Mar
    @RequestMapping(value = "array.do")
    @ResponseBody
    public  String array(String[] name) {
        StringBuilder sbf = new StringBuilder();
        for (String item : name) {
            sbf.append(item).append("   ");
        }

        return sbf.toString();
    }

    //对象
    //todo http://localhost:8080/object.do?name=Jack&age=10
    //todo  http://localhost:8080/object.do?name=Jack&age=10&contactInfo.phoneNumber=18601976945
    @RequestMapping(value = "object.do")
    @ResponseBody
    public  String object(User user) {
        return user.toString();
    }


    //List

    @RequestMapping(value = "list.do")
    @ResponseBody
    public  String list(UserListForm userListForm) {

        return userListForm.toString();

    }

    //Map
    /*
    {
        "name": "张三",
        "age": 10,
        "contactInfo": {
            "phoneNumber": "18601976945",
            "address": "减法分解机 "
        }
    }
    */
    @RequestMapping(value = "json.do")
    @ResponseBody
    public  String json(@RequestBody User user) {

        return user.toString();

    }

    @RequestMapping(value = "date1.do")
    @ResponseBody
    public  String date1(Date date1) {
        return  date1.toString();
    }

    @InitBinder("date1")
    public  void  initDate1(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-DD"),true));
    }



    @RequestMapping(value = "/book",method = RequestMethod.GET)
    @ResponseBody
    public String book(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null) {
            return  "book.default";
        }else if (contentType.equals("txt")) {
            return "book.txt";
        }else if (contentType.equals("html")) {
            return "book.html";
        }

        return "book.default";
    }


    //豆瓣电影请求
    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.GET)
    @ResponseBody
    public  String subjectGet(@PathVariable("subjectId") String subjectId) {
        return "this is a get method, subjectId:" + subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.POST)
    @ResponseBody
    public  String subjectPost(@PathVariable("subjectId") String subjectId) {
        return "this is a post  method, subjectId:" + subjectId;
    }
}

