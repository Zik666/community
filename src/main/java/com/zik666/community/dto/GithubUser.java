package com.zik666.community.dto;

import lombok.Data;

/**
 * @author Zik666
 * @date 2020-02-08 - 2:29
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
