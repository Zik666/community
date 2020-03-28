package com.zik666.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author baobao
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
