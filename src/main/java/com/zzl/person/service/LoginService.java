package com.zzl.person.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzl.person.bean.User;

public interface LoginService extends IService<User>{

    public User getUserByUsername(String username,String password);
}
