package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.common.util.Base64;
import com.mtgz.sc.manager.dao.mapper.CommentMapper;
import com.mtgz.sc.manager.dao.mapper.CommentPictureMapper;
import com.mtgz.sc.manager.dao.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 用户评价Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-28 17:03:40
 */
@Service("commentService")
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentPictureMapper commentPictureMapper;


    public Comment queryObject(Integer id) {
        return commentMapper.queryObject(id);
    }


    public List<Comment> queryList(Map<String, Object> map) {
        List<Comment> commentEntities = commentMapper.queryList(map);
        if (null != commentEntities && commentEntities.size() > 0) {
            for (Comment comment : commentEntities) {
                comment.setContent(Base64.decode(comment.getContent()));
            }
        }
        return commentEntities;
    }


    public int queryTotal(Map<String, Object> map) {
        return commentMapper.queryTotal(map);
    }


    public int save(Comment comment) {
        return commentMapper.save(comment);
    }


    public int update(Comment comment) {
        return commentMapper.update(comment);
    }


    @Transactional
    public int delete(Integer id) {
        //删除评论同时删除评论的图片
        commentPictureMapper.deleteByCommentId(id);
        return commentMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return commentMapper.deleteBatch(ids);
    }


    public int toggleStatus(Comment comment) {
        Comment old = queryObject(comment.getId());
        if (comment.getStatus() == 1) {
            old.setStatus(0);
        } else if (comment.getStatus() == 0) {
            old.setStatus(1);
        }
        return commentMapper.update(old);
    }
}
