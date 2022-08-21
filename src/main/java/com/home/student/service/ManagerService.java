package com.home.student.service;

import com.home.student.bean.req.LoginReq;
import com.home.student.bean.res.Result;
import com.home.student.bean.vo.JwtManagerVO;

public interface ManagerService {
    Result<JwtManagerVO> login(LoginReq loginReq);
}
