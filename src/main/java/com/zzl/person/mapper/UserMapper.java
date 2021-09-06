package com.zzl.person.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.person.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username = #{username} and password = #{password} and DFlag = 0")
    public User getByUsername(String username, String password);
}
