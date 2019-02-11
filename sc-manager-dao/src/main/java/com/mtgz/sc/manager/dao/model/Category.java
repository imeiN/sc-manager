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
@Table(name = "nideshop_category")
public class Category extends Tree<Category> {
    private static final long serialVersionUID = 1872446499625253889L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String keywords;

    @Column(name = "front_desc")
    private String frontDesc;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "sort_order")
    private Boolean sortOrder;

    @Column(name = "show_index")
    private Boolean showIndex;

    @Column(name = "is_show")
    private Boolean isShow;

    @Column(name = "banner_url")
    private String bannerUrl;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "wap_banner_url")
    private String wapBannerUrl;

    private String level;

    private Integer type;

    @Column(name = "front_name")
    private String frontName;

}