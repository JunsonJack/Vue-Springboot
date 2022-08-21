package com.home.student.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.home.student.bean.dto.JwtManagerDTO;
import com.home.student.bean.entity.Manager;
import com.home.student.bean.req.LoginReq;
import com.home.student.bean.res.Result;
import com.home.student.bean.vo.JwtManagerVO;
import com.home.student.mapper.ManagerMapper;
import com.home.student.service.ManagerService;
import com.home.student.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Result<JwtManagerVO> login(LoginReq loginReq) {
        //查询用户是否存在
        LambdaQueryWrapper<Manager> qw=new LambdaQueryWrapper<>();
        qw.eq(Manager::getUserName,loginReq.getUserName())
                .eq(Manager::getPwd,loginReq.getPwd());
       Manager manager= managerMapper.selectOne(qw);
       if (manager == null) {
           return Result.buildFailure("用户名或密码不正确");
       }
       JwtManagerVO vo = generateToken(manager);
       log.info("result:{}",vo);
        return Result.buildSuccess(vo);
    }

    private JwtManagerVO generateToken(Manager manager) {
       JwtManagerDTO jwtManagerDTO=  new JwtManagerDTO();
        BeanUtils.copyProperties(manager, jwtManagerDTO);
        String token= JwtUtil.getToken(jwtManagerDTO);
        //返回前端除了token，还有用户信息,vo包含了token和用户信息
        JwtManagerVO vo = new JwtManagerVO();
        BeanUtils.copyProperties(jwtManagerDTO, vo);
        log.info("result:{}",vo);
        vo.setToken(token);
        return vo;

    }
}
