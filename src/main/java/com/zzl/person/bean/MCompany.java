package com.zzl.person.bean;

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
@TableName("m_company")
public class MCompany {

    @TableId(value = "COMPANY_CD")
    private String companyCd;

    @TableField("COMPANY_NAME")
    private String companyName;

    @TableField("COMPANY_KB")
    private String companyKB;

    @TableField("POST_NO")
    private String postNo;

    @TableField("COMY_ADDR")
    private String comyAddr;

    @TableField("TEL_NO")
    private String telNo;

    @TableField("FAX_NO")
    private String faxNo;

    @TableField("MEMO")
    private String memo;

    @TableField("TAN_SYA_NAME")
    private String tanSyaName;

    @TableField("TAN_SYA_SYOKUMU")
    private String tanSyaSyokumu;

    @TableField("TORIHIKI_YMD")
    private Integer torihikiymd;

    @TableField("INS_SHA_CD")
    private String insShaCd;

    @TableField("INS_DT")
    private Timestamp insDt;

    @TableField("UPD_SHA_CD")
    private String updShaCd;

    @TableField("UPD_DT")
    private Timestamp updDt;

    @TableField("DFLAG")
    private Integer dFlag;

}
