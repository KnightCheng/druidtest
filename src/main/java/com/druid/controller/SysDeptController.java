package com.druid.controller;

import com.druid.common.JsonData;
import com.druid.dto.DeptLevelDto;
import com.druid.model.SysDept;
import com.druid.param.DeptParam;
import com.druid.service.SysDeptService;
import com.druid.service.SysTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {


    @Resource
    private SysTreeService sysTreeService;
    @Resource
    private SysDeptService sysDeptService;

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveDept(DeptParam param){
        sysDeptService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/dept.page")
    @ResponseBody
    public ModelAndView page(){
        return new ModelAndView("dept");
    }


    /**
     * 部门树列表
     * */
    @RequestMapping("/tree.json")
    @ResponseBody
    public JsonData tree(){
        List<DeptLevelDto> dtoList=sysTreeService.deptTree();
        return JsonData.success(dtoList);
    }

    /**
     * 部门更新
     * */
    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData update(DeptParam param){
        sysDeptService.update(param);
        return JsonData.success();
    }

}
