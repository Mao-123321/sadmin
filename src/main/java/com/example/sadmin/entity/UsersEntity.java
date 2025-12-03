package com.example.sadmin.entity;

import com.easy.query.core.proxy.ProxyEntityAvailable;
import com.example.sadmin.entity.proxy.UsersEntityProxy;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.easy.query.core.annotation.Column;
import com.easy.query.core.annotation.Table;
import com.easy.query.core.annotation.EntityProxy;

/**
 * 用户表 实体类。
 *
 * @author easy-query-plugin automatic generation
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "users")
@EntityProxy
public class UsersEntity implements ProxyEntityAvailable<UsersEntity , UsersEntityProxy> {

    /**
     * 用户ID
     */
    @Column(primaryKey = true, value = "id")
    private Integer id;

    /**
     * 关联部门ID
     */
    private Integer deptId;

    /**
     * 关联角色ID
     */
    private Integer roleId;

    /**
     * 账户账号
     */
    private String username;

    /**
     * 账户密码
     */
    private String password;

    /**
     * 账户盐值
     */
    private String salts;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 用户备注
     */
    private String remarks;

    /**
     * 账户状态，1正常/0禁用
     */
    private Integer status;

    /**
     * 删除状态，0未删除
     */
    private Long deleted;


}
