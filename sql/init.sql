CREATE TABLE `soybean_users`
(
    `user_id`      bigint                       NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `dept_id`      bigint                        DEFAULT NULL COMMENT '部门ID',
    `username`    varchar(30) COLLATE utf8_bin NOT NULL COMMENT '用户账号',
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
    `create_by`    bigint                        DEFAULT NULL COMMENT '创建者',
    `update_by`    bigint                        DEFAULT NULL COMMENT '更新者',
    `extra`        longtext COLLATE utf8_bin     DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='用户信息表';


CREATE TABLE `soybean_role`
(
  `role_id`               bigint(20)                    NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name`             varchar(30)                   NOT NULL COMMENT '角色名称',
  `role_key`              varchar(100)                  NOT NULL COMMENT '角色权限字符串',
  `role_sort`             int(4)                        NOT NULL COMMENT '显示顺序',
  `data_scope`            char(1)                       DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly`   tinyint(1)                    DEFAULT '1' COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly`   tinyint(1)                    DEFAULT '1' COMMENT '部门树选择项是否关联显示',
  `status`                char(1)                       NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag`              char(1)                       DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `gmt_create`            bigint                        DEFAULT NULL COMMENT '创建时间',
  `gmt_modified`          bigint                        DEFAULT NULL COMMENT '更新时间',
  `create_by`             bigint                        DEFAULT NULL COMMENT '创建者',
  `update_by`             bigint                        DEFAULT NULL COMMENT '更新者',
  `extra`                 longtext COLLATE utf8_bin     DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='角色信息表';

CREATE TABLE `soybean_user_role`
(
  `user_id`           bigint(20)       NOT NULL COMMENT '用户ID',
  `role_id`           bigint(20)       NOT NULL COMMENT '角色ID',
  `del_flag`          char(1)          DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `gmt_create`        bigint(20)       DEFAULT NULL COMMENT '创建时间',
  `gmt_modified`      bigint(20)       DEFAULT NULL COMMENT '更新时间',
  `create_by`         bigint(20)       DEFAULT NULL COMMENT '创建者',
  `update_by`         bigint(20)       DEFAULT NULL COMMENT '更新者',
  `extra`             longtext         COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='用户和角色关联表';

CREATE TABLE `soybean_menu`
(
   `menu_id`          bigint(20)                    NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
   `menu_name`        varchar(50)                   NOT NULL COMMENT '菜单名称',
   `parent_id`        bigint(20)                    DEFAULT '0' COMMENT '父菜单ID',
   `order_num`        int(4)                        DEFAULT '0' COMMENT '显示顺序',
   `path`             varchar(200)                  DEFAULT '' COMMENT '路由地址',
   `component`        varchar(255)                  DEFAULT NULL COMMENT '组件路径',
   `is_frame`         int(1)                        DEFAULT '1' COMMENT '是否为外链（0是 1否）',
   `is_cache`         int(1)                        DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
   `menu_type`        char(1)                       DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
   `visible`          char(1)                       DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
   `status`           char(1)                       DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
   `perms`            varchar(100)                  DEFAULT NULL COMMENT '权限标识',
   `icon`             varchar(100)                  DEFAULT '#' COMMENT '菜单图标',
   `del_flag`         char(1)                       DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
   `gmt_create`       bigint                        DEFAULT NULL COMMENT '创建时间',
   `gmt_modified`     bigint                        DEFAULT NULL COMMENT '更新时间',
   `create_by`        bigint                        DEFAULT NULL COMMENT '创建者',
   `update_by`        bigint                        DEFAULT NULL COMMENT '更新者',
   `extra`            longtext COLLATE utf8_bin     DEFAULT NULL COMMENT '备注',
   PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='菜单权限表';

CREATE TABLE `soybean_role_menu`
(
  `role_id`           bigint(20)       NOT NULL COMMENT '角色ID',
  `menu_id`           bigint(20)       NOT NULL COMMENT '菜单ID',
  `del_flag`          char(1)          DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `gmt_create`        bigint(20)       DEFAULT NULL COMMENT '创建时间',
  `gmt_modified`      bigint(20)       DEFAULT NULL COMMENT '更新时间',
  `create_by`         bigint(20)       DEFAULT NULL COMMENT '创建者',
  `update_by`         bigint(20)       DEFAULT NULL COMMENT '更新者',
  `extra`             longtext         COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='角色和菜单关联表';