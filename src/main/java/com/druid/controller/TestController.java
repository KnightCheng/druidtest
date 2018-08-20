package com.druid.controller;

import com.druid.dao.SysAclMapper;
import com.druid.model.SysAcl;
import com.druid.service.SysAclService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Resource
    private SysAclMapper sysAclMapper;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){

        return "hello permission";
    }

    @RequestMapping(value = "/model")
    @ResponseBody
    public SysAcl model(){
        return  sysAclMapper.selectByPrimaryKey(1);
    }
}

