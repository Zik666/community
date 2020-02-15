package com.zik666.community.controller;

import com.zik666.community.dto.PaginationDTO;
import com.zik666.community.dto.QuestionDTO;
import com.zik666.community.mapper.QuestionMapper;
import com.zik666.community.mapper.UserMapper;
import com.zik666.community.model.Question;
import com.zik666.community.model.User;
import com.zik666.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Zik666
 * @date 2020-02-07 - 17:28
 */
@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
