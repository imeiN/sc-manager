package com.mtgz.sc.manager.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nideshop_comment")
public class Comment {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型
     */
    @Column(name = "type_id")
    private Byte typeId;

    @Column(name = "value_id")
    private Integer valueId;

    /**
     * 储存为base64编码
     */
    private String content;

    /**
     * 记录时间
     */
    @Column(name = "add_time")
    private Long addTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 会员Id
     */
    @Column(name = "user_id")
    private Integer userId;

}