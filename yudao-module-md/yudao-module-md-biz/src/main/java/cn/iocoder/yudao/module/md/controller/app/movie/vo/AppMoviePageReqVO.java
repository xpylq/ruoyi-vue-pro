package cn.iocoder.yudao.module.md.controller.app.movie.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Schema(description = "前台 - 影片分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMoviePageReqVO extends PageParam {

    @Schema(description = "标题")
    private String title;

    @Schema(description = "类型", example = "1")
    private String type;

    @Schema(description = "地区")
    private String area;

    @Schema(description = "作者")
    private String author;

    @Schema(description = "排序类型（hot:热门，time:最新）")
    private String orderType;


}
