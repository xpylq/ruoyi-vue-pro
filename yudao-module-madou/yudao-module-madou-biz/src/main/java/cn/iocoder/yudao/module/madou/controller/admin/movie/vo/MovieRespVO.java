package cn.iocoder.yudao.module.madou.controller.admin.movie.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 影片 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MovieRespVO {

    @Schema(description = "影片主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "27054")
    @ExcelProperty("影片主键")
    private Long id;

    @Schema(description = "关联id", requiredMode = Schema.RequiredMode.REQUIRED, example = "7122")
    @ExcelProperty("关联id")
    private Long refId;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "标题", converter = DictConvert.class)
    @DictFormat("madou_movie_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String title;

    @Schema(description = "类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "类型", converter = DictConvert.class)
    @DictFormat("madou_movie_area") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String type;

    @Schema(description = "地区", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "地区", converter = DictConvert.class)
    @DictFormat("madou_movie_area") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String area;

    @Schema(description = "作者", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("作者")
    private String author;

    @Schema(description = "时长", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("时长")
    private Integer duration;

    @Schema(description = "观看次数", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("观看次数")
    private Long viewTimes;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}