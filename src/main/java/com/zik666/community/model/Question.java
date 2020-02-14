package com.zik666.community.model;

import lombok.Data;

/**
 * @author Zik666
 * @date 2020-02-12 - 2:01
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
