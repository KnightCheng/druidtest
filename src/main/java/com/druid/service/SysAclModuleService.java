package com.druid.service;

import com.druid.dao.SysAclModuleMapper;
import com.druid.model.SysAclModule;
import com.druid.param.AclModuleParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

public class SysAclModuleService {

    @Resource
    private SysAclModuleMapper sysAclModuleMapper;

    public void save(AclModuleParam param){}

    public void update(AclModuleParam param){}

    public void updateWithchild(SysAclModule sysAclModule){}


}
