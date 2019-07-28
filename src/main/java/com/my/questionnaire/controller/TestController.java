package com.my.questionnaire.controller;

import com.my.questionnaire.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Chen Wei
 * @Date: Created in 16:41 2019/7/18
 */
@Controller
public class TestController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("users", userMapper.getAll());
        return modelAndView;
    }
}
