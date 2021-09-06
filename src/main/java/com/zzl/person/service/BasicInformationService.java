package com.zzl.person.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzl.person.bean.MEmployee;

import java.util.List;

public interface BasicInformationService extends IService<MEmployee> {

    public MEmployee getMEmployeeByEmpNo(String empNo);

    public int updateEmployee(String empNo, String field, String attributes);

    public List<MEmployee> searchEmployeeByEmpNameKanji(String empNameKanji);
}
