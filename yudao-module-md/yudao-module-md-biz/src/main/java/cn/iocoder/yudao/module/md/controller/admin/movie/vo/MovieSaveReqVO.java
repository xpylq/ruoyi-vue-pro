package cn.iocoder.yudao.module.md.controller.admin.movie.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 影片新增/修改 Request VO")
@Data
public class MovieSaveReqVO {

    @Schema(description = "影片主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "27054")
    private Long id;

    @Schema(description = "关联id", requiredMode = Schema.RequiredMode.REQUIRED, example = "7122")
    @NotNull(message = "关联id不能为空")
    private Long refId;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "标题不能为空")
    private String title;

    @Schema(description = "类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "类型不能为空")
    private String type;

    @Schema(description = "地区", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "地区不能为空")
    private String area;

    @Schema(description = "作者", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "作者不能为空")
    private String author;

    @Schema(description = "时长", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "时长不能为空")
    private Integer duration;

    @Schema(description = "观看次数", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "观看次数不能为空")
    private Long viewTimes;

    @Schema(description = "图片url", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "图片url不能为空")
    private String imageUrl;

}