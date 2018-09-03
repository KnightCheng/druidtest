package com.druid.controller;

import com.druid.beans.PageQuery;
import com.druid.beans.PageResult;
import com.druid.common.JsonData;
import com.druid.param.UserParam;
import com.druid.model.SysUser;
import com.druid.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveUser(UserParam param){
        sysUserService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateUser(UserParam param){
        sysUserService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/page.json")
    @ResponseBody
    public JsonData page(@RequestParam("deptId")int deptId, PageQuery pageQuery){
        PageResult<SysUser> result=sysUserService.getPageByDeptId(deptId,pageQuery);
        return JsonData.success(result);
    }
}
