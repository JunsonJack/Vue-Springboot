package com.home.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.home.student.bean.entity.Student;
import com.home.student.bean.req.CommonSearchReq;
import com.home.student.bean.vo.StudentVO;

import java.util.List;

//指定好mapper对应的实体类 <>泛型
public interface StudentMapper extends BaseMapper<Student> {

    List<StudentVO> queryList(CommonSearchReq searchReq);
}
