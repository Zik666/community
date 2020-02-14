package com.zik666.community.dto;

import lombok.Data;

/**
 * @author Zik666
 * @date 2020-02-08 - 1:34
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
