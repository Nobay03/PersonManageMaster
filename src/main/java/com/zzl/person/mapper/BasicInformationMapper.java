package com.zzl.person.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.person.bean.MEmployee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BasicInformationMapper extends BaseMapper<MEmployee> {

    @Select("select * from m_employee where EMP_NO = #{empNo} and DFLAG = 0")
    public MEmployee getByEmpNo(String empNo);

    @Update("update m_employee set ${field} = #{attributes} where EMP_NO = #{empNo} and DFLAG = 0")
    public int updateEmployee(String empNo, String field, String attributes);

    @Select("select EMP_NO, EMP_NAME_KANJI from m_employee where EMP_NAME_KANJI like concat('%',#{empNameKanji},'%') and DFLAG = 0")
    public List<MEmployee> searchEmployeeByEmpNameKanji(String empNameKanji);
}
