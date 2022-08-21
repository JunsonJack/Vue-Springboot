package com.home.student.service;

import com.home.student.bean.req.CommonSearchReq;
import com.home.student.bean.req.ScoreAddReq;
import com.home.student.bean.req.ScoreUpdateReq;
import com.home.student.bean.res.Result;
import com.home.student.bean.vo.ScoreVO;

import java.util.List;

public interface ScoreService {
    /**
     * 新增成绩
     */
    void add(ScoreAddReq addReq);

    Result<List<ScoreVO>> selectPage(CommonSearchReq searchReq);

    void deleteById(Long id);

    Result<ScoreVO> selectById(Long id);

    void updateById(ScoreUpdateReq updateReq);
}
