package com.home.student.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("student")
public class Student {
    /**
     * 指定主键自增
     */
    @TableId(type = IdType.AUTO)

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
