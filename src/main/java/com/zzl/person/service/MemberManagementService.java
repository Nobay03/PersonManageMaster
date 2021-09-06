package com.zzl.person.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzl.person.bean.MEmployee;

import java.util.List;

public interface MemberManagementService extends IService<MEmployee> {

    public List<MEmployee> getAllBase();
}
