/**
  创建 customer 用户表
 */
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`
(
    `id`                int(11) NOT NULL AUTO_INCREMENT,
    `name`              varchar(45)  DEFAULT NULL COMMENT '用户名',
    `login_name`        varchar(45)  DEFAULT NULL COMMENT '登录名',
    `avatar`            varchar(120) DEFAULT NULL COMMENT '用户头像',
    `gender`            tinyint(1) DEFAULT NULL COMMENT '用户性别：0 女，1 男',
    `email`             varchar(254) DEFAULT NULL COMMENT '邮箱',
    `latest_login_time` datetime     DEFAULT NULL COMMENT '最近登录时间',
    `status`            tinyint(1) DEFAULT '0' COMMENT '用户状态：0 正常，1 禁用',
    `description`       varchar(200) DEFAULT NULL COMMENT '简介描述',
    `create_by`         varchar(45)  DEFAULT NULL COMMENT '创建人',
    `create_time`       datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`         varchar(45)  DEFAULT NULL COMMENT '更新操作人',
    `update_time`       datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_delete`         tinyint(1) DEFAULT '0' COMMENT '是否删除：0 未删除，1 已删除',
    `delete_by`         int(11) DEFAULT NULL COMMENT '操作删除用户ID',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';