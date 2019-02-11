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
@Table(name = "nideshop_search_history")
public class SearchHistory {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 搜索来源，如PC、小程序、APP等
     */
    private String from;

    /**
     * 搜索时间
     */
    @Column(name = "add_time")
    private Integer addTime;

    /**
     * 会员Id
     */
    @Column(name = "user_id")
    private String userId;

}