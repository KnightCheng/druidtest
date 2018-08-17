package com.druid.controller;

import com.druid.model.SysAcl;
import com.druid.service.SysAclService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private SysAclService sysAclService;



    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){

        return "hello permission";
    }

    @RequestMapping("/model")
    public SysAcl model(){
        return sysAclService.selectByPrimaryKey(1);
    }
}

