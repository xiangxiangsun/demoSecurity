package com.example.demoSecurity.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 返回权限验证的接口
 */
public interface RbacService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
