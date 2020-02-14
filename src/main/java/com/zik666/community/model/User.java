package com.zik666.community.model;

import lombok.Data;

/**
 * @author Zik666
 * @date 2020-02-09 - 21:07
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
