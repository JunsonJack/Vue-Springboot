package com.home.student.bean.vo;

import lombok.Data;

import java.util.Date;

@Data
public class StudentVO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 学号
     */
    private String no;
    /**
     * 学生姓名
     */
    private String realName;
    /**
     * 入学日期
     */
    private Date enrollTime;

}
