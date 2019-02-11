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
@Table(name = "tb_token")
public class Token {
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    @Column(name = "expire_time")
    private Date expireTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

}