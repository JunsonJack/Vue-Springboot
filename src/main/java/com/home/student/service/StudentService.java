package com.home.student.service;

import com.home.student.bean.req.CommonSearchReq;
import com.home.student.bean.req.StudentAddReq;
import com.home.student.bean.req.StudentUpdateReq;
import com.home.student.bean.res.Result;
import com.home.student.bean.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StudentService {
    /**
     * 新增学生
     * @param addReq
     */
    void add(StudentAddReq addReq);

    /**
     * 学生的分页查询
     * @param searchReq
     * @return
     */

    Result<List<StudentVO>> selectPage(CommonSearchReq searchReq);

    void deleteById(Long id);


    Result<StudentVO> selectById(Long id);

    void updateById(StudentUpdateReq updateReq);

    Result<List<StudentVO>> selectAll();
}
