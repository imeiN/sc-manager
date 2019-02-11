package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.dao.config.MyMapper;
import com.mtgz.sc.manager.dao.model.CommentPicture;

public interface CommentPictureMapper extends MyMapper<CommentPicture> {
    int deleteByCommentId(Integer commentId);
}