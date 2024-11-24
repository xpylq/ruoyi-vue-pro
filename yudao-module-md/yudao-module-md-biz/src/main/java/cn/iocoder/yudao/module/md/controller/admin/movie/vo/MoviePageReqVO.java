package cn.iocoder.yudao.module.md.controller.admin.movie.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 影片分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MoviePageReqVO extends PageParam {

    @Schema(description = "关联id", example = "7122")
    private Long refId;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "类型", example = "1")
    private String type;

    @Schema(description = "地区")
    private String area;

    @Schema(description = "作者")
    private String author;

    @Schema(description = "时长")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Integer[] duration;

    @Schema(description = "观看次数")
    private Long viewTimes;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}