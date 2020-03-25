package com.zik666.community.mapper;

import com.zik666.community.model.Comment;
import com.zik666.community.model.Question;
import org.springframework.stereotype.Repository;

/**
 * @author : Zik666
 * @date : 3:39 2020-02-24
 */
@Repository
public interface CommentExtraMapper {
    int incCommentCount(Comment record);
}
