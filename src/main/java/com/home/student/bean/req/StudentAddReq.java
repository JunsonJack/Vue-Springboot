package com.home.student.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StudentAddReq {
    /**
     * 学号
     *  @NotBlank 非空
     */
    @NotBlank
    private String no;
    /**
     * 学生姓名
     */
    @NotBlank
    private String realName;
    /**
     * 入学日期
     */
    @NotNull
    private Date enrollTime;
}
