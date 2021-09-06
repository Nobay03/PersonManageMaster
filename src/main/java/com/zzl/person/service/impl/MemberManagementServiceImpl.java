package com.zzl.person.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.person.bean.MEmployee;
import com.zzl.person.mapper.MemberManagementMapper;
import com.zzl.person.service.MemberManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberManagementServiceImpl extends ServiceImpl<MemberManagementMapper, MEmployee> implements MemberManagementService {

    @Autowired
    MemberManagementMapper managementMapper;

    @Override
    public List<MEmployee> getAllBase() {

        return managementMapper.getAllBase();
    }
}
