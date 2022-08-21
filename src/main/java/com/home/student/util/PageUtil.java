package com.home.student.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.home.student.bean.res.Result;

import java.util.List;

/**
 * 分页工具类
 */
public class PageUtil {
    /**
     * 开始分页
     * @param pageNow
     * @param pageSize
     */
    public static void startPage(Integer pageNow, Integer pageSize){
        PageHelper.startPage(pageNow,pageSize);
    }

    /**
     * 转化查询结果
     * @param queryList
     * @param <T>
     * @return
     */
    public static <T> Result<List<T>> wrapPageDate(List<T> queryList){
        PageInfo<T> pageInfo = new PageInfo<T>(queryList);
        return Result.buildSuccess(queryList,pageInfo.getTotal());
    }
}
