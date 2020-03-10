package com.example.demoSecurity.security;

import com.example.demoSecurity.entity.SysRole;
import com.example.demoSecurity.entity.SysUser;
import com.example.demoSecurity.entity.SysUserRole;
import com.example.demoSecurity.service.RoleSecurityService;
import com.example.demoSecurity.service.UserRoleService;
import com.example.demoSecurity.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-06
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

/*
    @Autowired
    private UserSecurityService userSecurityService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleSecurityService roleSecurityService;

  //数据库实现
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = userSecurityService.selectByName(username);
        //判断用户是否存在
        if (user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        //添加权限
        List<SysUserRole> sysUserRoles = userRoleService.listByUserId(user.getId());

        for (SysUserRole sysUserRole : sysUserRoles) {
            SysRole sysRole = roleSecurityService.selectById(sysUserRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(sysRole.getName()));
        }

        return new User(user.getUsername(),user.getPassword(),authorities);
    }*/

    //方法不走数据库
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里可以可以通过username（登录时输入的用户名）然后到数据库中找到对应的用户信息，并构建成我们自己的UserInfo来返回。
        //这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
//        if(username.equals("admin")) {
            //假设返回的用户信息如下;
//            SysUser userInfo = new SysUser();
//            userInfo.setUsername("admin");
//            userInfo.setPassword("123456");
//            userInfo.setRole("Role_ADMIN");
//            return userInfo;

            //方法2  模拟数据库带权限
            if (username.equals("admin")){
                //假设返回信息如下
                SysUser userInfo = new SysUser("admin","123456","ROLE_ADMIN",true,true,true,true);
                return userInfo;
        }
            if (username.equals("user")){
                //假设返回信息如下
                SysUser userInfo = new SysUser("user","123456","ROLE_USER",true,true,true,true);
                return userInfo;
        }

        return null;
    }
}
