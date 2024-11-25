use ruoyi_md;
DROP TABLE IF EXISTS `md_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `md_movie` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '影片主键',
                            `ref_id` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '关联id',
                            `title` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
                            `type` varchar(256) COLLATE utf8mb4_bin NOT NULL DEFAULT 'self' COMMENT '类型',
                            `area` varchar(256) COLLATE utf8mb4_bin NOT NULL DEFAULT 'asia' COMMENT '地区',
                            `author` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '作者',
                            `duration` int NOT NULL COMMENT '时长（单位秒）',
                            `view_times` bigint NOT NULL DEFAULT '0' COMMENT '观看次数',
                            `image_url` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '图片url',
                            `creator` varchar(64) COLLATE utf8mb4_bin DEFAULT '' COMMENT '创建者',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `updater` varchar(64) COLLATE utf8mb4_bin DEFAULT '' COMMENT '更新者',
                            `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
                            `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户编号',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY `idx_refId` (`ref_id`) USING BTREE,
                            KEY `idx_title` (`title`) USING BTREE,
                            KEY `idx_author` (`author`) USING BTREE,
                            KEY `idx_viewTimes` (`view_times`) USING BTREE,
                            KEY `idx_createTime_viewTimes` (`create_time`,`view_times`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2205 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='影片表';

