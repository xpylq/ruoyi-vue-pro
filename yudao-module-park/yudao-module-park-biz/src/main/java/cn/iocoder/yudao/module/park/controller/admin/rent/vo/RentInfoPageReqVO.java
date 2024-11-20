package cn.iocoder.yudao.module.park.controller.admin.rent.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 车位租赁信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RentInfoPageReqVO extends PageParam {

    @Schema(description = "用户ID", example = "30464")
    private Long userId;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "租赁人类型：0-个人 1-物业", example = "1")
    private Integer renterType;

    @Schema(description = "是否为固定车位 0-否 1-是")
    private Integer isFixed;

    @Schema(description = "车位类型：0-地面车位 1-地面机械车位 2-地下车位 3-地下机械车位", example = "2")
    private Integer parkType;

    @Schema(description = "每月价格，单位：分", example = "2120")
    private Integer price;

    @Schema(description = "状态: 0-待审核 1-审核通过 2-已租赁 3-已下架", example = "2")
    private Integer status;

    @Schema(description = "纬度")
    private Double latitude;

    @Schema(description = "经度")
    private Double longitude;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "详细地址")
    private String detailAddress;

    @Schema(description = "描述", example = "你猜")
    private String description;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}