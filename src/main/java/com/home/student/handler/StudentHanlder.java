package com.home.student.handler;

import com.home.student.bean.req.CommonSearchReq;
import com.home.student.bean.req.StudentAddReq;
import com.home.student.bean.req.StudentUpdateReq;
import com.home.student.bean.res.Result;
import com.home.student.bean.vo.StudentVO;
import com.home.student.service.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentHanlder {
    @Resource
    private StudentService studentService;


    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated StudentAddReq addReq){
        studentService.add(addReq);
        return Result.buildSuccess("添加成功");
    }

    /**
     * 分页查询
     */
    @PostMapping("/selectPage")
    public Result<List<StudentVO>>add(@RequestBody CommonSearchReq searchReq){
       return studentService.selectPage(searchReq);
    }

    @GetMapping("/deleteById")
    public Result<String> deleteById(Long id){
        if(id == null){
            return Result.buildFailure("id不能为空");
        }
        studentService.deleteById(id);
        return Result.buildSuccess("删除成功");
    }

    @GetMapping("/selectById")
    public Result<StudentVO> selectById(Long id){
        if(id == null){
            return Result.buildFailure("id不能为空");
        }
        return  studentService.selectById(id);
    }

    @PostMapping("/updateById")
    public Result<String> updateById(@RequestBody @Validated StudentUpdateReq updateReq){
        studentService.updateById(updateReq);
        return Result.buildSuccess("更新成功");
    }

    @GetMapping("/selectAll")
    public Result<List<StudentVO>>selectAll(){
        return studentService.selectAll();
    }
}
