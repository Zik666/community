package com.zik666.community.dto;

import com.zik666.community.model.User;
import lombok.Data;

/**
 * @author Zik666
 * @date 2020-02-13 - 16:22
 */
@Data
public class QuestionDTO {
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
    private User user;
}
