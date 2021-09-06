package com.zzl.person.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.person.bean.User;
import com.zzl.person.mapper.UserMapper;
import com.zzl.person.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUsername(String username, String password) {

        return userMapper.getByUsername(username, password);
    }
}
