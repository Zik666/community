package com.zik666.community.controller;

import com.zik666.community.dto.CommentCreateDTO;
import com.zik666.community.dto.CommentDTO;
import com.zik666.community.dto.QuestionDTO;
import com.zik666.community.service.CommentService;
import com.zik666.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Zik666
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model){
        QuestionDTO questionDTO = questionService.getById(id);

        List<CommentDTO> comments = commentService.listByQuestionId(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("questionDTO", questionDTO);
        model.addAttribute("comments", comments);
        return "question";
    }
}
