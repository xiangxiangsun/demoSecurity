package com.example.demoSecurity.security;

import com.example.demoSecurity.entity.SysRole;
import com.example.demoSecurity.entity.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-06
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里可以可以通过username（登录时输入的用户名）然后到数据库中找到对应的用户信息，并构建成我们自己的UserInfo来返回。
        //这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
        if(username.equals("admin")) {
            //假设返回的用户信息如下;
            SysUser userInfo = new SysUser();
            userInfo.setUsername("admin");
            userInfo.setPassword("123456");
            SysRole role = new SysRole(1L,"ADMIN");
            List<SysRole> list = new ArrayList();
            list.add(role);
            userInfo.setRoles(list);
            return userInfo;

            //方法2  模拟数据库带权限
//            if (username.equals("admin")){
//                //假设返回信息如下
//                SysUser userInfo = new SysUser("admin","123456","Role_ADMIN");
        }
        return null;
    }
}
