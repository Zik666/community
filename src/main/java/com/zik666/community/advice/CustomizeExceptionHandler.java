package com.zik666.community.advice;

import com.zik666.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : Zik666
 * @date : 22:30 2020-02-23
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable throwable, Model model) {
        if (throwable instanceof CustomizeException) {
            model.addAttribute("message", throwable.getMessage());
        } else {
            model.addAttribute("message", "服务器冒烟了，要不您稍后再试试！！！");
        }
        return new ModelAndView("error");
    }
}
