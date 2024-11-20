package cn.iocoder.yudao.module.park.dal.dataobject.rent;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 车位租赁信息 DO
 *
 * @author 芋道源码
 */
@TableName("park_rent_info")
@KeySequence("park_rent_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentInfoDO extends BaseDO {

    /**
     * 车位租赁信息ID
     */
    @TableId
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 租赁人类型：0-个人 1-物业
     */
    private Integer renterType;
    /**
     * 是否为固定车位 0-否 1-是
     */
    private Integer isFixed;
    /**
     * 车位类型：0-地面车位 1-地面机械车位 2-地下车位 3-地下机械车位
     */
    private Integer parkType;
    /**
     * 每月价格，单位：分
     */
    private Integer price;
    /**
     * 状态: 0-待审核 1-审核通过 2-已租赁 3-已下架
     */
    private Integer status;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 详细地址
     */
    private String detailAddress;
    /**
     * 描述
     */
    private String description;

}