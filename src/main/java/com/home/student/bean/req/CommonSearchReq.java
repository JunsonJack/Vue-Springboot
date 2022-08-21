package com.home.student.bean.req;

import com.home.student.bean.constants.Constants;
import lombok.Data;

@Data
public class CommonSearchReq {
    /**
     * 当前要查询第几页
     */
    private Integer pageNow = Constants.DEFAULT_PAGE_NOW;
    /**
     * 每页的大小
     */
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
    /**
     * 通用的搜索词
     */
    private String searchWord;

}
