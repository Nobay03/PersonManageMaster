package com.zzl.person.bean;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("m_employee")
public class MEmployee {

    @TableField(value = "COMPANY_CD", updateStrategy = FieldStrategy.NOT_NULL)
    private String companyCd;

    @TableId(value = "EMP_NO")
    private String empNo;

    @TableField(value = "EMP_NAME_KANJI", updateStrategy = FieldStrategy.NOT_NULL)
    private String empNameKanji;

    @TableField(value = "EMP_NAME_FURIGANA", updateStrategy = FieldStrategy.NOT_NULL)
    private String empNameFurigana;

    @TableField(value = "EMP_NAME_ROMA", updateStrategy = FieldStrategy.NOT_NULL)
    private String empNameRoma;

    @TableField(value = "BIRTHDAY_YMD", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer birthdayYmd;

    @TableField(value = "SEX_FLG", updateStrategy = FieldStrategy.NOT_NULL)
    private String sexFlg;

    @TableField("TEL_NO_JP")
    private String telNoJp;

    @TableField("PC_MAIL")
    private String pcMail;

    @TableField("TEL_MAIL")
    private String telMail;

    @TableField("ADDRESS_JP")
    private String addressJp;

    @TableField("EMP_DIV_CD")
    private String empDivCd;

    @TableField("NYUSYA_YMD")
    private Integer nyusyaYmd;

    @TableField("EMP_FLG")
    private String empFlg;

    @TableField("DEPART_CD")
    private String departCd;

    @TableField("TAISYOKU_YMD")
    private Integer taisyokuYmd;

    @TableField("GRAD_COLG_NM")
    private String gradColgNm;

    @TableField("GRAD_YMD")
    private Integer gradYmd;

    @TableField("GRAD_MAJOR")
    private String gradMajor;

    @TableField("MEMO")
    private String memo;

    @TableField("TEL_NO_CN")
    private String telNoCn;

    @TableField("ADDRESS_CN")
    private String addressCn;

    @TableField("RES_NO")
    private String resNo;

    @TableField("RES_QUA")
    private String resQua;

    @TableField("MY_NO")
    private String myNo;

    @TableField("EMP_INS_FLG")
    private String empInsFlg;

    @TableField("EMP_INS_NUMBER")
    private String empInsNumber;

    @TableField("PEN_FLG")
    private String penFlg;

    @TableField("PEN_NUMBER")
    private String penNumber;

    @TableField(value = "INS_SHA_CD", updateStrategy = FieldStrategy.NOT_NULL)
    private String insShaCd;

    @TableField(value = "INS_DT", updateStrategy = FieldStrategy.NOT_NULL)
    private Timestamp insDt;

    @TableField(value = "UPD_SHA_CD", updateStrategy = FieldStrategy.NOT_NULL)
    private String updShaCd;

    @TableField(value = "UPD_DT", updateStrategy = FieldStrategy.NOT_NULL)
    private Timestamp updDt;

    @TableField(value = "DFLAG", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer dFlag;
}
