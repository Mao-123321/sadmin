package com.example.sadmin.controller;

import com.easy.query.api.proxy.client.EasyEntityQuery;
import com.easy.query.api.proxy.entity.select.EntityQueryable;
import com.easy.query.solon.annotation.Db;
import com.example.sadmin.entity.LoginlogEntity;
import com.example.sadmin.entity.UsersEntity;
import com.example.sadmin.entity.proxy.UsersEntityProxy;
import com.example.sadmin.util.MD5SaltsUtil;
import com.example.sadmin.util.ResponseResult;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import org.noear.solon.core.handle.Context;

/**
 * 权限认证
 */
@Mapping("/passport")// 注意这里路径是 /passport/xxx
@Controller
public class PassportController {
    @Db
    EasyEntityQuery easyEntityQuery;
    @Post
    @Mapping("login")
    public ResponseResult login(Context ctx, String username, String password) {
        //根据账号查询用户对象
        UsersEntity usersEntity = easyEntityQuery.queryable(UsersEntity.class)
                .where(u ->{
                    //数据库条件：u.username = #{username}
                    u.username().eq(username);
                })
                .firstOrNull();
        if (usersEntity == null){
            return ResponseResult.failure("用户不存在", null);
        }
        //密码验证
        //使用MD5SaltsUtil中的md5方法，获取前端穿过来的明文密码，在通过数据库获取对应的盐值进行MD5加密
        //最后根据数据库中的密文密码进行比较
        String md5SaltsPassword  = MD5SaltsUtil.md5(password, usersEntity.getSalts());
        if (!usersEntity.getPassword().equals(md5SaltsPassword)){
            return ResponseResult.failure("密码错误", null);
        }
        //查询用户的状态：0.禁用 1.正常
        if (usersEntity.getStatus() != 0){
            return ResponseResult.failure("用户被禁用", null);
        }
        //全部验证通过
        //保存登录日志
        //创建日志对象
        LoginlogEntity loginlogEntity = new LoginlogEntity();
        //设置关联用户ID
        loginlogEntity.setUserId(usersEntity.getId());
        loginlogEntity.setIp(ctx.realIp());
        return ResponseResult.success("登录成功", null);
    }
}
