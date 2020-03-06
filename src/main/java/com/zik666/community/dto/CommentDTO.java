package com.zik666.community.dto;

import lombok.Data;

/**
 * @author : Zik666
 * @date : 20:17 2020-02-24
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
