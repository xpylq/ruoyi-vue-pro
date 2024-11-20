package cn.iocoder.yudao.module.park.controller.admin.rent.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 车位租赁信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class RentInfoRespVO {

    @Schema(description = "车位租赁信息ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "30720")
    @ExcelProperty("车位租赁信息ID")
    private Long id;

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "30464")
    @ExcelProperty("用户ID")
    private Long userId;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("标题")
    private String title;

    @Schema(description = "租赁人类型：0-个人 1-物业", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("租赁人类型：0-个人 1-物业")
    private Integer renterType;

    @Schema(description = "是否为固定车位 0-否 1-是", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否为固定车位 0-否 1-是")
    private Integer isFixed;

    @Schema(description = "车位类型：0-地面车位 1-地面机械车位 2-地下车位 3-地下机械车位", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("车位类型：0-地面车位 1-地面机械车位 2-地下车位 3-地下机械车位")
    private Integer parkType;

    @Schema(description = "每月价格，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "2120")
    @ExcelProperty("每月价格，单位：分")
    private Integer price;

    @Schema(description = "状态: 0-待审核 1-审核通过 2-已租赁 3-已下架", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("状态: 0-待审核 1-审核通过 2-已租赁 3-已下架")
    private Integer status;

    @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("纬度")
    private Double latitude;

    @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("经度")
    private Double longitude;

    @Schema(description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("手机号")
    private String mobile;

    @Schema(description = "详细地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("详细地址")
    private String detailAddress;

    @Schema(description = "描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "你猜")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}