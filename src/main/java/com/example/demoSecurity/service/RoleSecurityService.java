package com.example.demoSecurity.service;

import com.example.demoSecurity.entity.SysRole;
import com.example.demoSecurity.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-09
 */

@Service
public class RoleSecurityService {
    @Resource
    private RoleMapper roleMapper;

    public SysRole selectById(Integer id){return roleMapper.selectById(id);}
}
