package com.example.demoSecurity.service;

import com.example.demoSecurity.entity.SysUser;
import com.example.demoSecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-09
 */
@Service
public class UserSecurityService {

    @Resource
    private UserMapper userMapper;

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }

}
