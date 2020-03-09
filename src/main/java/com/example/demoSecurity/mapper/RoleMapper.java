package com.example.demoSecurity.mapper;

import com.example.demoSecurity.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {

    @Select("select * from sys_role where id = #{id}")
    SysRole selectById(Integer id);
}
