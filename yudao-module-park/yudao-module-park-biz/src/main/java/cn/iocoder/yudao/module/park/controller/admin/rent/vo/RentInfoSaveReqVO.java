package cn.iocoder.yudao.module.park.controller.admin.rent.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 车位租赁信息新增/修改 Request VO")
@Data
public class RentInfoSaveReqVO {

    @Schema(description = "车位租赁信息ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "30720")
    private Long id;

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "30464")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "标题不能为空")
    private String title;

    @Schema(description = "租赁人类型：0-个人 1-物业", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "租赁人类型：0-个人 1-物业不能为空")
    private Integer renterType;

    @Schema(description = "是否为固定车位 0-否 1-是", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否为固定车位 0-否 1-是不能为空")
    private Integer isFixed;

    @Schema(description = "车位类型：0-地面车位 1-地面机械车位 2-地下车位 3-地下机械车位", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "车位类型：0-地面车位 1-地面机械车位 2-地下车位 3-地下机械车位不能为空")
    private Integer parkType;

    @Schema(description = "每月价格，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "2120")
    @NotNull(message = "每月价格，单位：分不能为空")
    private Integer price;

    @Schema(description = "状态: 0-待审核 1-审核通过 2-已租赁 3-已下架", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "状态: 0-待审核 1-审核通过 2-已租赁 3-已下架不能为空")
    private Integer status;

    @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "纬度不能为空")
    private Double latitude;

    @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "经度不能为空")
    private Double longitude;

    @Schema(description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "手机号不能为空")
    private String mobile;

    @Schema(description = "详细地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "详细地址不能为空")
    private String detailAddress;

    @Schema(description = "描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "你猜")
    @NotEmpty(message = "描述不能为空")
    private String description;

}