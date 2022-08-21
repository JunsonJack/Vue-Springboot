package com.home.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.home.student.bean.entity.Student;
import com.home.student.bean.req.CommonSearchReq;
import com.home.student.bean.req.StudentAddReq;
import com.home.student.bean.req.StudentUpdateReq;
import com.home.student.bean.res.Result;
import com.home.student.bean.vo.StudentVO;
import com.home.student.ex.BizEx;
import com.home.student.mapper.StudentMapper;
import com.home.student.service.StudentService;
import com.home.student.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(StudentAddReq addReq) {
        LambdaQueryWrapper <Student> qw = new LambdaQueryWrapper<>();
        qw.eq(Student ::getNo,addReq.getNo());
        Long count = studentMapper.selectCount(qw);
        if (count > 0) {
            throw new BizEx("学号已存在");
        }
        Student student = new Student();
        BeanUtils.copyProperties(addReq,student);
        studentMapper.insert(student);

    }

    @Override
    public Result<List<StudentVO>> selectPage(CommonSearchReq searchReq) {
        PageUtil.startPage(searchReq.getPageNow(), searchReq.getPageSize());
        List<StudentVO> list = studentMapper.queryList(searchReq);
        return PageUtil.wrapPageDate(list);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        studentMapper.deleteById(id);
    }

    @Override
    public Result<List<StudentVO>> selectAll() {
        List<StudentVO> list = studentMapper.queryList(new CommonSearchReq());
        return Result.buildSuccess(list);
    }

    @Override
    public Result<StudentVO> selectById(Long id) {
        Student student = studentMapper.selectById(id);
        if (student == null) {
            return Result.buildEmptySuccess();
        }
        StudentVO vo = new StudentVO();
        BeanUtils.copyProperties(student, vo);
        return Result.buildSuccess(vo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(StudentUpdateReq updateReq) {
        Student student =new Student();
        BeanUtils.copyProperties(updateReq, student);
        studentMapper.updateById(student);
    }
}
