package com.home.student.bean.dto;

import lombok.Data;

/**
 * 定义了返回给前端的token是由哪些信息生成的
 */
@Data
public class JwtManagerDTO {
    private Long id;
    /**
     * 用户名
     */
    private String userName;
}
