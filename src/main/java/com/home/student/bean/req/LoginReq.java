package com.home.student.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginReq {
    /**
     * NotBlank 参数校验，不为空
     * 用户名
     */
    @NotBlank
    private String userName;
    /**
     * 密码
     */
    @NotBlank
    private String pwd;
}
