CREATE TABLE `soybean_users`
(
    `user_id`      bigint                       NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `dept_id`      bigint                        DEFAULT NULL COMMENT '部门ID',
    `user_name`    varchar(30) COLLATE utf8_bin NOT NULL COMMENT '用户账号',
    `nick_name`    varchar(30) COLLATE utf8_bin NOT NULL COMMENT '用户昵称',
    `user_type`    varchar(2) COLLATE utf8_bin   DEFAULT '00' COMMENT '用户类型（00系统用户）',
    `email`        varchar(50) COLLATE utf8_bin  DEFAULT '' COMMENT '用户邮箱',
    `phone_number` varchar(11) COLLATE utf8_bin  DEFAULT '' COMMENT '手机号码',
    `sex`          char(1) COLLATE utf8_bin      DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
    `avatar`       varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '头像地址',
    `password`     varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '密码',
    `status`       char(1) COLLATE utf8_bin      DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
    `del_flag`     char(1) COLLATE utf8_bin      DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `login_ip`     varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '最后登录IP',
    `login_date`   datetime                      DEFAULT NULL COMMENT '最后登录时间',
    `gmt_create`   bigint                        DEFAULT NULL COMMENT '创建时间',
    `gmt_modified` bigint                        DEFAULT NULL COMMENT '更新时间',
    `extra`       longtext COLLATE utf8_bin     DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='用户信息表';