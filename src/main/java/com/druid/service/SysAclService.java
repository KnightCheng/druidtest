package com.druid.service;

import com.druid.dao.SysAclMapper;
import com.druid.model.SysAcl;
import com.druid.model.SysAclModule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysAclService {

    @Resource
    private SysAclMapper sysAclMapper;

    public SysAcl selectByPrimaryKey(Integer id){
        return sysAclMapper.selectByPrimaryKey(id);
    }
}
