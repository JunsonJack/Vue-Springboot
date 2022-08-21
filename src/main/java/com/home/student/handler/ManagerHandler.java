package com.home.student.handler;

import com.home.student.bean.req.LoginReq;
import com.home.student.bean.res.Result;
import com.home.student.bean.vo.JwtManagerVO;
import com.home.student.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/manager")
public class ManagerHandler {
    @Resource
    private ManagerService managerService;

    @PostMapping("/login")
    public Result<JwtManagerVO> login(@RequestBody @Validated LoginReq loginReq) {
        log.info("login params:{}",loginReq);
        return managerService.login(loginReq);
    }

    @PostMapping("/login2")
    public Result<JwtManagerVO> login2( @Validated LoginReq loginReq) {
        log.info("login params:{}",loginReq);
        return managerService.login(loginReq);
    }

}
