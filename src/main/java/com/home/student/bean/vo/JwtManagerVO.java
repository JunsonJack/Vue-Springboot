package com.home.student.bean.vo;

import com.home.student.bean.dto.JwtManagerDTO;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class JwtManagerVO extends JwtManagerDTO {
    private String token;

}
