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
@Table(name = "nideshop_coupon_goods")
public class CouponGoods {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 优惠券Id
     */
    @Column(name = "coupon_id")
    private Integer couponId;

    /**
     * 商品id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

}