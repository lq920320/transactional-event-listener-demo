package com.example.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author zetu
 * @date 2022/3/2
 */
@Data
@Accessors(chain = true)
@TableName("customer")
public class Customer {
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 创建人
     */
    private Integer createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除人
     */
    private Integer deleteBy;
    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 用户名
     */
    private String name;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户性别：0 女，1 男
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最近登录事件
     */
    private Date latestLoginTime;

    /**
     * 用户状态：0 正常，1 禁用
     */
    private Integer status;

    /**
     * 简介描述
     */
    private String description;
}
