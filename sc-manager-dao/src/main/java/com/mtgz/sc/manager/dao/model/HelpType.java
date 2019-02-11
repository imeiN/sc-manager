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
@Table(name = "nideshop_help_type")
public class HelpType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 问题分类
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 排序
     */
    private Integer sort;
}