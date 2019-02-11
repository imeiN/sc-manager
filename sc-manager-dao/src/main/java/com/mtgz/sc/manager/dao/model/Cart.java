package com.mtgz.sc.manager.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "nideshop_cart")
public class Cart {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 会员Id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * sessionId
     */
    @Column(name = "session_id")
    private String sessionId;

    /**
     * 商品Id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 商品序列号
     */
    @Column(name = "goods_sn")
    private String goodsSn;

    /**
     * 产品Id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 产品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 市场价
     */
    @Column(name = "market_price")
    private BigDecimal marketPrice;

    /**
     * 零售价格
     */
    @Column(name = "retail_price")
    private BigDecimal retailPrice;

    /**
     * 数量
     */
    private Short number;

    /**
     * product表对应的goods_specifition_ids
     */
    @Column(name = "goods_specifition_ids")
    private String goodsSpecifitionIds;

    private Boolean checked;

    /**
     * 商品图片
     */
    @Column(name = "list_pic_url")
    private String listPicUrl;

    /**
     * 规格属性组成的字符串，用来显示用
     */
    @Column(name = "goods_specifition_name_value")
    private String goodsSpecifitionNameValue;

    public Cart(Integer id, Integer userId, String sessionId, Integer goodsId, String goodsSn, Integer productId, String goodsName, BigDecimal marketPrice, BigDecimal retailPrice, Short number, String goodsSpecifitionIds, Boolean checked, String listPicUrl, String goodsSpecifitionNameValue) {
        this.id = id;
        this.userId = userId;
        this.sessionId = sessionId;
        this.goodsId = goodsId;
        this.goodsSn = goodsSn;
        this.productId = productId;
        this.goodsName = goodsName;
        this.marketPrice = marketPrice;
        this.retailPrice = retailPrice;
        this.number = number;
        this.goodsSpecifitionIds = goodsSpecifitionIds;
        this.checked = checked;
        this.listPicUrl = listPicUrl;
        this.goodsSpecifitionNameValue = goodsSpecifitionNameValue;
    }

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 获取会员Id
     *
     * @return user_id - 会员Id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 获取sessionId
     *
     * @return session_id - sessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 获取商品Id
     *
     * @return goods_id - 商品Id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 获取商品序列号
     *
     * @return goods_sn - 商品序列号
     */
    public String getGoodsSn() {
        return goodsSn;
    }

    /**
     * 获取产品Id
     *
     * @return product_id - 产品Id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 获取产品名称
     *
     * @return goods_name - 产品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 获取市场价
     *
     * @return market_price - 市场价
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * 获取零售价格
     *
     * @return retail_price - 零售价格
     */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    /**
     * 获取数量
     *
     * @return number - 数量
     */
    public Short getNumber() {
        return number;
    }

    /**
     * 获取product表对应的goods_specifition_ids
     *
     * @return goods_specifition_ids - product表对应的goods_specifition_ids
     */
    public String getGoodsSpecifitionIds() {
        return goodsSpecifitionIds;
    }

    /**
     * @return checked
     */
    public Boolean getChecked() {
        return checked;
    }

    /**
     * 获取商品图片
     *
     * @return list_pic_url - 商品图片
     */
    public String getListPicUrl() {
        return listPicUrl;
    }

    /**
     * 获取规格属性组成的字符串，用来显示用
     *
     * @return goods_specifition_name_value - 规格属性组成的字符串，用来显示用
     */
    public String getGoodsSpecifitionNameValue() {
        return goodsSpecifitionNameValue;
    }
}