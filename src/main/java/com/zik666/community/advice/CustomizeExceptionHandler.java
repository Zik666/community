package com.zik666.community.advice;

import com.alibaba.fastjson.JSON;
import com.zik666.community.dto.ResultDTO;
import com.zik666.community.exception.CustomizeErrorCode;
import com.zik666.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : Zik666
 * @date : 22:30 2020-02-23
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
     ModelAndView handle(Throwable throwable,
                         Model model,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)) {
            //返回json
            ResultDTO resultDTO;
            if (throwable instanceof CustomizeException) {
                resultDTO = ResultDTO.errorOf((CustomizeException) throwable);
            } else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            //错误页面跳转
            if (throwable instanceof CustomizeException) {
                model.addAttribute("message", throwable.getMessage());
            } else {
                model.addAttribute("message", CustomizeErrorCode.SYS_ERROR);
            }
            return new ModelAndView("error");
        }
    }
}
