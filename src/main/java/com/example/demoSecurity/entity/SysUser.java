package com.example.demoSecurity.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.Collection;


/**
 * @author: sunxiangxiang
 * @data: 2020-03-06
 */
@Setter
@Getter
public class SysUser implements Serializable,UserDetails {
    private static final long serialVersionUID = 1L;
//    private Integer id;
    private String username;
    private String password;
    private String role;

    //账户是否过期
    private boolean accountNonExpired;
    //账户是否锁定
    private boolean accountNonLocked;
    //凭证是否过期
    private boolean credentialsNonExpired;
    //账户是否启用
    private boolean enabled;

    public SysUser(String username, String password, String role, boolean accountNonExpired, boolean accountNonLocked,
                    boolean credentialsNonExpired, boolean enabled) {
        // TODO Auto-generated constructor stub
        this.username = username;
        this.password = password;
        this.role = role;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public SysUser() {

    }

    // 这是权限
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    }
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return accountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return accountNonLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return credentialsNonExpired;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return enabled;
    }
}
