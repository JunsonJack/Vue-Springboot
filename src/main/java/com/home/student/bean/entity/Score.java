package com.home.student.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("score")
public class Score {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 外键student表的id
     */
    private Long studentId;
    /**
     * 考试名称
     */
    private String examName;
    /**
     * 语文成绩
     */
    private Double cnScore;
    /**
     * 英语成绩
     */
    private Double enScore;
    /**
     * 数学成绩
     */
    private Double mathScore;
}
