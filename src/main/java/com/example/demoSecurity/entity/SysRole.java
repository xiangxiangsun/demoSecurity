package com.example.demoSecurity.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-06
 */
public class SysRole {
    private Long id;
    private String name;
    private String keyword; // 角色关键字，用于权限控制
    private String description; // 描述
    private Set<SysUser> users = new HashSet<SysUser>(0);

    public SysRole(Long id, String name, String keyword, String description, Set<SysUser> users) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.description = description;
        this.users = users;
    }

    public SysRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }
}
