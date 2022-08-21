package com.home.student.bean.res;

import com.home.student.bean.enums.CodeEnum;
import lombok.Data;

/**
 * 统一返回结果
 * 所有的返回结果都是这个格式
 */
@Data
public class Result<T> {
    /**
     * 响应码
     */
    private Integer code = CodeEnum.SUCCESS.getCode();
    /**
     * 响应信息
     */
    private String msg=CodeEnum.SUCCESS.getMsg();

    /**
     * 用于判断是否成功或者失败
     * true:成功，false:失败
     */
    private Boolean success=Boolean.TRUE;

    private T data;

    private Long total;

    private Result(){
        //构造
    }

    /**
     * 成功类的方法
     */
    public static <T> Result<T> buildEmptySuccess(){
        return new Result<>();
    }
    public static <T> Result<T> buildSuccess(T t){
        Result<T> result= buildEmptySuccess();
        result.setData(t);
        return result;
    }

    /**
     *
     * @param t
     * @param total 用于返回表格的总条数
     * @param <T>
     * @return
     */
    public static <T> Result<T> buildSuccess(T t,Long total){
        Result<T> result= buildSuccess(t);
        result.setTotal(total);
        return result;
    }

    /**
     * 失败类的方法
     */
    public static <T> Result<T> buildFailure(String msg){
        Result<T> result= new Result<>();
        result.setCode(null);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }
    public static <T> Result<T> buildFailure(Integer code,String msg){
        Result<T> result= new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> buildFailure(CodeEnum codeEnum){
        Result<T> result= new Result<>();
        result.setCode(codeEnum.getCode());
        result.setMsg(codeEnum.getMsg());
        result.setSuccess(false);
        return result;
    }

    /**
     * 方便判断是否成功
     */
    public boolean isSuccess(){
        return success;
    }

    /**
     * 方便判断是否失败
     */
    public boolean isFailed(){
        return !isSuccess();
    }





}
