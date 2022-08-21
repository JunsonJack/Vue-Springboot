package com.home.student.util;
import com.alibaba.fastjson.JSON;
import com.home.student.bean.constants.Constants;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ResponseUtil {
    /**
     * 向浏览器写入响应数据
     * @param response
     * @param obj
     */
    public static void respAppJson(HttpServletResponse response,Object obj) {
        response.setCharacterEncoding(Constants.UTF_8_NAME);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try(PrintWriter pw = response.getWriter()) {
            pw.print(JSON.toJSONString(obj));
            pw.flush();
        }catch (IOException e) {
            log.error("写到前端异常",e);
        }


    }
}
