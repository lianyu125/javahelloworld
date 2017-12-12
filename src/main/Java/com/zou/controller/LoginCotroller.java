package com.zou.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;

import jdk.nashorn.api.scripting.JSObject;
import com.zou.model.Student;
import com.zou.model.Teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



//import dao.Get;
//import dao.StudentDAO;

//登陆servlet
@Controller
public class LoginCotroller {
    /**
     * 1. value="/doLogin/{username}/{password}" 拦截 xxx/doLogin/xx/xx
     * 2. @ResponseBody 使用此注解将返回数据类型封装json
     * 3. @PathVariable("username") 截取请求1.value中{username}的值
     * 4. Map<String, Object> 服务端将值放入map中再封装为json,客户端方便通过key取出value
     */

//    StudentDAO studentDAO = new StudentDAO();//调用登陆判断方法

    @RequestMapping(value="/doLogin/{username}/{password}",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTeacher(@PathVariable("username") Integer username, @PathVariable("password") String password){
        System.out.println("拦截了客户端json请求");
        Map<String, Object> map = new HashMap<String, Object>();

            System.out.println("密码正确");
            map.put("result", "1");
            return map; //封装为json返回给客户端

//        System.out.println("密码错误");
//        map.put("result", "0");
//        return map; //封装为json返回给客户端
    }

}
