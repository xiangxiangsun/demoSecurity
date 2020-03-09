package com.example.demoSecurity.service;

import com.example.demoSecurity.entity.SysUserRole;
import com.example.demoSecurity.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-09
 */
@Service
public class UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId){return userRoleMapper.ListByUserId(userId);}
}
