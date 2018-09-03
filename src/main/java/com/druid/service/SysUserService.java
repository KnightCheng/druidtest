package com.druid.service;

import com.druid.beans.PageQuery;
import com.druid.beans.PageResult;
import com.druid.dao.SysUserMapper;
import com.druid.exception.ParamException;
import com.druid.param.UserParam;
import com.druid.model.SysUser;
import com.druid.util.BeanValidator;
import com.druid.util.MD5Util;
import com.druid.util.PasswordUtil;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 用户保存
     * */
    public void save(UserParam param){
        BeanValidator.check(param);
        if(checkTelephoneExist(param.getTelephone(),param.getId())){
            throw new ParamException("电话被占用");
        }
        if(checkEmailExist(param.getMail(),param.getId())){
            throw new ParamException("邮箱被占用");
        }
        String password= PasswordUtil.randomPassword();


        password="123456";

        String encryptedPassword= MD5Util.encrypt(password);
        SysUser user= SysUser.builder().username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail())
                .password(encryptedPassword).deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        user.setOperateIp("127.0.0.1");
        user.setOperator("admin");
        user.setOperateTime(new Date());

        //TODO: send email
        sysUserMapper.insertSelective(user);

    }

    private boolean checkTelephoneExist(String telephone,Integer userId){
      return sysUserMapper.countByTelephone(telephone,userId)>0;
    }

    private boolean checkEmailExist(String mail,Integer userId){
        return sysUserMapper.countByMail(mail,userId)>0;
    }


    /**
     *用户更新
     */
    public void update(UserParam param){
        BeanValidator.check(param);
        if(checkTelephoneExist(param.getTelephone(),param.getId())){
            throw new ParamException("电话已被占用");
        }
        if(checkEmailExist(param.getMail(),param.getId())){
            throw new ParamException("邮箱已被占用");
        }
        SysUser before=sysUserMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before,"待更新的用户不存在");
        SysUser after=SysUser.builder().id(param.getId()).username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail())
                .deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        after.setOperateIp("127.0.0.1");
        after.setOperator("admin");
        after.setOperateTime(new Date());

        sysUserMapper.updateByPrimaryKeySelective(after);
    }

    public SysUser findByKeyword(String keyword){
        return sysUserMapper.findByKeyword(keyword);
    }

    public PageResult<SysUser> getPageByDeptId(int deptId, PageQuery page){
        BeanValidator.check(page);
        int count=sysUserMapper.countByDeptId(deptId);
        if(count>0){
            List<SysUser> list=sysUserMapper.getPageByDeptId(deptId,page);
            return PageResult.<SysUser>builder().total(count).data(list).build();
        }
        return PageResult.<SysUser>builder().build();
    }

    public List<SysUser> getAll(){
        return sysUserMapper.getAll();
    }
}
