package com.zzl.person.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.person.bean.MEmployee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberManagementMapper extends BaseMapper<MEmployee> {

    @Select("select EMP_NO, EMP_NAME_KANJI from m_employee where DFLAG = 0")
    public List<MEmployee> getAllBase();
}
