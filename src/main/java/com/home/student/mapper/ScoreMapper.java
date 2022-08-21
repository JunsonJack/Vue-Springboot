package com.home.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.home.student.bean.entity.Score;
import com.home.student.bean.req.CommonSearchReq;
import com.home.student.bean.vo.ScoreVO;

import java.util.List;

public interface ScoreMapper extends BaseMapper<Score> {

    List<ScoreVO> queryList(CommonSearchReq searchReq);

}
