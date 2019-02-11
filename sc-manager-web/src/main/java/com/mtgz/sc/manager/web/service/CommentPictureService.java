package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.CommentPictureMapper;
import com.mtgz.sc.manager.dao.model.CommentPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 评价图片Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-29 14:45:55
 */
@Service("commentPictureService")
public class CommentPictureService {
    @Autowired
    private CommentPictureMapper commentPictureMapper;


    public CommentPicture queryObject(Integer id) {
        return commentPictureMapper.queryObject(id);
    }


    public List<CommentPicture> queryList(Map<String, Object> map) {
        return commentPictureMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return commentPictureMapper.queryTotal(map);
    }


    public int save(CommentPicture commentPicture) {
        return commentPictureMapper.save(commentPicture);
    }


    public int update(CommentPicture commentPicture) {
        return commentPictureMapper.update(commentPicture);
    }


    public int delete(Integer id) {
        return commentPictureMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return commentPictureMapper.deleteBatch(ids);
    }


    public int deleteByCommentId(Integer commentId) {
        return commentPictureMapper.deleteByCommentId(commentId);
    }
}
