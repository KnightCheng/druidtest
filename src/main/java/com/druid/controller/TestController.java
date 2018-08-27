package com.druid.controller;

import com.druid.common.JsonData;
import com.druid.common.SpringExceptionResolver;
import com.druid.dao.SysAclMapper;
import com.druid.dto.DeptLevelDto;
import com.druid.exception.PermissionException;
import com.druid.model.SysAcl;
import com.druid.param.TestVo;
import com.druid.service.SysTreeService;
import com.druid.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private SysTreeService sysTreeService;


    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){

        return "hello permission";
    }


    @RequestMapping("/json.json")
    @ResponseBody
    public JsonData json(){
        throw new PermissionException();
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo){
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }

    @RequestMapping("/deptLevelList.json")
    @ResponseBody
    public JsonData getDeptLevelDtoList(){
        List<DeptLevelDto> list=sysTreeService.deptTree();
        return JsonData.success(list);
    }
}

