CREATE TABLE `park_rent_info`
(
    `id`             bigint       NOT NULL AUTO_INCREMENT COMMENT '车位租赁信息ID',
    `user_id`        bigint       NOT NULL COMMENT '用户ID',
    `title`          varchar(128) NOT NULL COMMENT '标题',
    `renter_type`    tinyint      NOT NULL COMMENT '租赁人类型：0-个人 1-物业',
    `is_fixed`       tinyint      NOT NULL COMMENT '是否为固定车位 0-否 1-是',
    `park_type`      tinyint      NOT NULL COMMENT '车位类型：0-地面车位 1-地面机械车位 2-地下车位 3-地下机械车位',
    `status`         tinyint      NOT NULL COMMENT '状态: 0-待审核 1-审核通过 2-已租赁 3-已下架',
    `price`          int          NOT NULL DEFAULT 0 COMMENT '每月价格，单位：分',
    `latitude`       double       NOT NULL COMMENT '纬度',
    `longitude`      double       NOT NULL COMMENT '经度',
    `mobile`         varchar(20)  NOT NULL COMMENT '手机号',
    `detail_address` varchar(256) NOT NULL COMMENT '详细地址',
    `description`    varchar(512) NOT NULL DEFAULT '' COMMENT '描述',
    `creator`        varchar(64)           DEFAULT '' COMMENT '创建者',
    `create_time`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`        varchar(64)           DEFAULT '' COMMENT '更新者',
    `update_time`    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`        bit(1)       NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`      bigint       NOT NULL DEFAULT '0' COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='车位租赁信息';

