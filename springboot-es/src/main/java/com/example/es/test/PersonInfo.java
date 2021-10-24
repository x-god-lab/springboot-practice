package com.example.es.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 人员信息对象 person_info
 * 
 * @author ruoyi
 * @date 2021-09-19
 */
@Data
public class PersonInfo {
    private static final long serialVersionUID = 1L;

    /** 人员id */
    private String personId;

    /** 姓名 */
    private String name;

    /** 性别 */
    private String sex;

    /** 年龄 */
    private Long age;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    /** 身份证号 */
    private String idCardNo;

    /** 地址 */
    private String address;

    /** 邮箱 */
    private String email;

    /** 手机号码 */
    private String phone;

    /** 是否有工作 */
    private String work;
}
