package com.home.student.ex;

import com.home.student.bean.enums.CodeEnum;
import lombok.Data;

/**
 * 业务逻辑异常
 */
@Data
public class BizEx extends RuntimeException {
    private Integer code;
    public BizEx(String msg){
        super(msg);
    }
    public BizEx(CodeEnum codeEnum){
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
    }
}
