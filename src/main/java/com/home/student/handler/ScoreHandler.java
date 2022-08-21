package com.home.student.handler;

import com.home.student.bean.entity.Score;
import com.home.student.bean.req.CommonSearchReq;
import com.home.student.bean.req.ScoreAddReq;
import com.home.student.bean.req.ScoreUpdateReq;
import com.home.student.bean.res.Result;
import com.home.student.bean.vo.ScoreVO;
import com.home.student.bean.vo.StudentVO;
import com.home.student.service.ScoreService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreHandler {
    @Resource
    private ScoreService scoreService;

    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated ScoreAddReq addReq) {
        scoreService.add(addReq);
        return Result.buildSuccess("添加成功");
    }

    @PostMapping("/selectPage")
    public Result<List<ScoreVO>>add(@RequestBody CommonSearchReq searchReq){
        return scoreService.selectPage(searchReq);
    }

    @GetMapping("/deleteById")
    public Result<String> deleteById(Long id){
        if(id == null){
            return Result.buildFailure("id不能为空");
        }
        scoreService.deleteById(id);
        return Result.buildSuccess("删除成功");
    }

    @GetMapping("/selectById")
    public Result<ScoreVO> selectById(Long id){
        if(id == null){
            return Result.buildFailure("id不能为空");
        }
        return  scoreService.selectById(id);
    }
    @PostMapping("/updateById")
    public Result<String>updateById(@RequestBody @Validated ScoreUpdateReq updateReq){
        scoreService.updateById(updateReq);
        return Result.buildSuccess("更新成功！");
    }

}
