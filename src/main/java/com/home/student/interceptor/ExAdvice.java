package com.home.student.interceptor;

import com.home.student.bean.enums.CodeEnum;
import com.home.student.ex.BizEx;
import com.home.student.bean.res.Result;
import lombok.extern.slf4j.Slf4j;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ExAdvice {

    /**
     * 处理BindException类型的异常
     * 出现时机
     * Content-Type:application/x-www-form-url encoded
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result<String> handleEX(BindException e){
        log.error("参数绑定异常",e);
        //获取到没用过校验的字段详情
        List<FieldError> fieldErrors= e.getFieldErrors();
        return Result.buildFailure(spliceErrMsg(fieldErrors));
    }


    /**
     * 处理MethodArgumentNotValidException类型的异常
     * 出现时机：
     * Content-Type:application/json+后台使用  @ResponseBody
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<String> handleEX(MethodArgumentNotValidException e){
        log.error("入参校验失败",e);
        BindingResult bindingResult = e.getBindingResult();
        //获取到没用过校验的字段详情
        List<FieldError> fieldErrors= bindingResult.getFieldErrors();

        return Result.buildFailure(spliceErrMsg(fieldErrors));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<String> handleEX(IllegalArgumentException e){
        log.error("参数非法",e);
        return Result.buildFailure(CodeEnum.PARAM_ERR);
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    public Result<String> handleEX(BadSqlGrammarException e){
        log.error("数据库异常",e);
        return Result.buildFailure(CodeEnum.DB_ERR);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result<String> handleEX(DuplicateKeyException e){
        log.error("唯一性约束校验异常",e);
        return Result.buildFailure(CodeEnum.DUPLICATE_KEY_ERR);
    }

    @ExceptionHandler(BizEx.class)
    public Result<String> handleEX(BizEx e){
        log.error("业务异常",e);
        return Result.buildFailure(e.getCode(),e.getMessage());
    }

    /**
     * 处理未精准匹配的异常
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleEX(Exception e){
        log.error("未精准匹配的异常",e);
        return Result.buildFailure(CodeEnum.SYS_ERR);
    }

    /**
     * 拼接
     * @param fieldErrors
     * @return
     */
    private String spliceErrMsg(List<FieldError> fieldErrors){
        return  fieldErrors.stream().map(fieldError -> {
            StringBuilder sb = new StringBuilder();
            sb.append("属性：").append(fieldError.getField())
                    .append(",传来的值是：").append(fieldError.getRejectedValue())
                    .append(",校验不通过,原因是:").append(fieldError.getDefaultMessage());
            return sb.toString();
        }).collect(Collectors.joining(";"));
    }
}
