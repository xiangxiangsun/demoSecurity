package com.example.demoSecurity.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-09
 */

@Setter
@Getter
@TableName(value = "sys_user_role")
public class SysUserRole implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer roleId;
}
