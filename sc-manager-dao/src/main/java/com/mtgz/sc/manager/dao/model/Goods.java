package com.mtgz.sc.manager.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nideshop_goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "goods_sn")
    private String goodsSn;

    private String name;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "goods_number")
    private Integer goodsNumber;

    private String keywords;

    @Column(name = "goods_brief")
    private String goodsBrief;

    @Column(name = "is_on_sale")
    private Integer isOnSale;

    @Column(name = "add_time")
    private Date addTime;

    @Column(name = "sort_order")
    private Short sortOrder;

    @Column(name = "is_delete")
    private Integer isDelete;

    @Column(name = "attribute_category")
    private Integer attributeCategory;

    /**
     * 专柜价格
     */
    @Column(name = "counter_price")
    private BigDecimal counterPrice;

    /**
     * 附加价格
     */
    @Column(name = "extra_price")
    private BigDecimal extraPrice;

    @Column(name = "is_new")
    private Boolean isNew;

    /**
     * 商品单位
     */
    @Column(name = "goods_unit")
    private String goodsUnit;

    /**
     * 商品主图
     */
    @Column(name = "primary_pic_url")
    private String primaryPicUrl;

    /**
     * 商品列表图
     */
    @Column(name = "list_pic_url")
    private String listPicUrl;

    /**
     * 零售价格
     */
    @Column(name = "retail_price")
    private BigDecimal retailPrice;

    /**
     * 销售量
     */
    @Column(name = "sell_volume")
    private Integer sellVolume;

    /**
     * 主sku　product_id
     */
    @Column(name = "primary_product_id")
    private Integer primaryProductId;

    /**
     * 单位价格，单价
     */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "promotion_desc")
    private String promotionDesc;

    @Column(name = "promotion_tag")
    private String promotionTag;

    /**
     * APP专享价
     */
    @Column(name = "app_exclusive_price")
    private BigDecimal appExclusivePrice;

    /**
     * 是否是APP专属
     */
    @Column(name = "is_app_exclusive")
    private Boolean isAppExclusive;

    @Column(name = "is_limited")
    private Boolean isLimited;

    @Column(name = "is_hot")
    private Boolean isHot;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    /**
     * 创建人ID
     */
    @Column(name = "create_user_id")
    private Long createUserId;

    /**
     * 修改人ID
     */
    @Column(name = "update_user_id")
    private Long updateUserId;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_user_dept_id")
    private Long createUserDeptId;

    @Column(name = "goods_desc")
    private String goodsDesc;

    @Transient
    List<GoodsAttribute> attributeList = new ArrayList<>();

    @Transient
    List<GoodsGallery> goodsImgList = new ArrayList<>();
}