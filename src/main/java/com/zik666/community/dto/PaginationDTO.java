package com.zik666.community.dto;

import lombok.Data;
import org.apache.ibatis.javassist.expr.NewArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zik666
 * @date 2020-02-13 - 21:30
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;
    private Boolean showFirstPage;
    private Boolean showNext;
    private Boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages;

    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        this.page = page;
        pages = new ArrayList<>();
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                getPages().add(0, page - i);
            }
            if (page + i <= totalPage) {
                getPages().add(page + i);
            }
        }
        showPrevious = page != 1;
        showNext = !page.equals(totalPage);
        showFirstPage = !getPages().contains(1);
        showEndPage = !getPages().contains(totalPage);
    }
}
