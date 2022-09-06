package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @BelongsProject: community
 * @Author: zhangyipeng
 * @CreateTime: 2022-08-18  09:32
 * @Description: TODO
 * @Version: 1.0
 */

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody
    public String saveHello(){
        return "Hello";
    }

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/data")
    @ResponseBody
    public String GetData() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }
        System.out.println(request.getParameter("code"));
        System.out.println(request.getParameter("name"));
        //向浏览器返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("<h1>牛客网<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //GET请求
    // /students?current=1&limit=20
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        System.out.println(current+":"+limit);
        return "some students";
    }

    // /student/123
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    //POST请求
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String savaStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "保存成功";
    }

//    @RequestMapping(path = "/teacher", method = RequestMethod.POST)
//    @ResponseBody
//    public String saveTeacher(String name, int age, int ageOfWork){
//        System.out.println(name + " " + age + " " + ageOfWork);
//        return "success";
//    }

    //响应HTML数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView teacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.addObject("age","30");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    //响应json数据（一般在异步请求）
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> setEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", "16");
        emp.put("salary", 1000);
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> setEmps(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", "16");
        emp.put("salary", 1000);
        list.add(emp);

        Map<String,Object> emp1 = new HashMap<>();
        emp1.put("name", "李四");
        emp1.put("age", "18");
        emp1.put("salary", 2000);
        list.add(emp1);

        Map<String,Object> emp2 = new HashMap<>();
        emp2.put("name", "王五");
        emp2.put("age", "17");
        emp2.put("salary", 1500);
        list.add(emp2);
        return list;
    }

}