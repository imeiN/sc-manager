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
@Table(name = "nideshop_specification")
public class Specification {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 规范名称
     */
    private String name;

    /**
     * 排序
     */
    @Column(name = "sort_order")
    private Byte sortOrder;

}