drop table if exists `md_movie`;
create table `md_movie`
(
    `id`          bigint       not null auto_increment comment '影片主键',
    `ref_id`      bigint       not null comment '关联id',
    `title`       varchar(256) not null comment '标题',
    `type` varchar(256) not null default 'self' comment '类型',
    `area` varchar(256) not null default 'asia' comment '地区',
    `author`      varchar(256) not null comment '作者',
    `duration`    int          not null comment '时长（单位秒）',
    `view_times`  bigint       not null default 0 comment '观看次数',
    `image_url`   varchar(256) not null comment '图片url',
    `creator`     varchar(64) null default '' comment '创建者',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `updater`     varchar(64) null default '' comment '更新者',
    `update_time` datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    `deleted`     bit(1)       not null default b'0' comment '是否删除',
    `tenant_id`   bigint       not null default 0 comment '租户编号',
    primary key (`id`) using btree,
    index         `idx_refId`(`ref_id`) using btree
) engine = innodb auto_increment = 32 character set = utf8mb4 collate = utf8mb4_bin comment = '影片表';
