package com.home.student.service.impl;

import com.home.student.bean.entity.Score;
import com.home.student.bean.entity.Student;
import com.home.student.bean.req.CommonSearchReq;
import com.home.student.bean.req.ScoreAddReq;
import com.home.student.bean.req.ScoreUpdateReq;
import com.home.student.bean.res.Result;
import com.home.student.bean.vo.ScoreVO;
import com.home.student.bean.vo.StudentVO;
import com.home.student.mapper.ScoreMapper;
import com.home.student.service.ScoreService;
import com.home.student.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public Result<ScoreVO> selectById(Long id) {
        Score score = scoreMapper.selectById(id);
        if (score == null) {
            return Result.buildEmptySuccess();
        }
        ScoreVO vo = new ScoreVO();
        BeanUtils.copyProperties(score, vo);
        return Result.buildSuccess(vo);
    }

//增删改都加上事务,查询不需要

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        scoreMapper.deleteById(id);
    }

    @Override
    public Result<List<ScoreVO>> selectPage(CommonSearchReq searchReq) {
        PageUtil.startPage(searchReq.getPageNow(), searchReq.getPageSize());
        List<ScoreVO> list = scoreMapper.queryList(searchReq);
        return PageUtil.wrapPageDate(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(ScoreAddReq addReq) {
        Score entity = new Score();
        BeanUtils.copyProperties(addReq, entity);
        scoreMapper.insert(entity);

    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(ScoreUpdateReq updateReq) {
        Score score = new Score();
        BeanUtils.copyProperties(updateReq, score);
        scoreMapper.updateById(score);

    }
}
