package com.example.sadmin.entity;

import com.easy.query.core.proxy.ProxyEntityAvailable;
import com.example.sadmin.entity.proxy.LoginlogEntityProxy;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.easy.query.core.annotation.Column;
import com.easy.query.core.annotation.Table;
import com.easy.query.core.annotation.EntityProxy;

/**
 * 登录日志表 实体类。
 *
 * @author easy-query-plugin automatic generation
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "loginlog")
@EntityProxy
public class LoginlogEntity implements ProxyEntityAvailable<LoginlogEntity , LoginlogEntityProxy> {

    /**
     * 日志ID
     */
    @Column(primaryKey = true, value = "id")
    private Integer id;

    /**
     * 关联用户ID
     */
    private Integer userId;

    /**
     * 登录IP信息
     */
    private String ip;

    /**
     * 登录IP地址
     */
    private String address;

    /**
     * 登录时间戳
     */
    private Long timestamp;


}
