package com.mtgz.sc.manager.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nideshop_user_coupon")
public class UserCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "coupon_number")
    private String couponNumber;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "used_time")
    private Date usedTime;

    @Column(name = "add_time")
    private Date addTime;

    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 来源key
     */
    @Column(name = "source_key")
    private String sourceKey;

    /**
     * 发券人
     */
    private Integer referrer;

    /**
     * 状态 1. 可用 2. 已用 3. 过期
     */
    @Column(name = "coupon_status")
    private Byte couponStatus;

}