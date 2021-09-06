package com.zzl.person.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.person.bean.MEmployee;
import com.zzl.person.mapper.BasicInformationMapper;
import com.zzl.person.service.BasicInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicInformationServiceImpl extends ServiceImpl<BasicInformationMapper, MEmployee> implements BasicInformationService {

    @Autowired
    BasicInformationMapper basicInformationMapper;

    @Override
    public MEmployee getMEmployeeByEmpNo(String empNo) {

        return basicInformationMapper.getByEmpNo(empNo);
    }

    public int updateEmployee(String empNo, String field, String attributes) {

        return basicInformationMapper.updateEmployee(empNo, field, attributes);
    }

    @Override
    public List<MEmployee> searchEmployeeByEmpNameKanji(String empNameKanji) {

        return basicInformationMapper.searchEmployeeByEmpNameKanji(empNameKanji);
    }
}
