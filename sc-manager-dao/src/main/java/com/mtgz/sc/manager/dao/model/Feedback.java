package com.mtgz.sc.manager.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nideshop_feedback")
public class Feedback {
    /**
     * 主键
     */
    @Id
    @Column(name = "msg_id")
    private Integer msgId;

    /**
     * 会员Id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 会员会员名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 反馈类型
     */
    @Column(name = "feed_Type")
    private Boolean feedType;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 反馈时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 详细内容
     */
    private String content;

}