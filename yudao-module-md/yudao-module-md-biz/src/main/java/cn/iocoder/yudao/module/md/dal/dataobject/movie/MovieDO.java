package cn.iocoder.yudao.module.md.dal.dataobject.movie;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 影片 DO
 *
 * @author 芋道源码
 */
@TableName("md_movie")
@KeySequence("md_movie_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDO extends BaseDO {

    /**
     * 影片主键
     */
    @TableId
    private Long id;
    /**
     * 关联id
     */
    private Long refId;
    /**
     * 标题
     *
     * 枚举 {@link TODO md_movie_type 对应的类}
     */
    private String title;
    /**
     * 类型
     *
     * 枚举 {@link TODO md_movie_area 对应的类}
     */
    private String type;
    /**
     * 地区
     *
     * 枚举 {@link TODO md_movie_area 对应的类}
     */
    private String area;
    /**
     * 作者
     */
    private String author;
    /**
     * 时长
     */
    private Integer duration;
    /**
     * 观看次数
     */
    private Long viewTimes;
    /**
     * 图片url
     */
    private String imageUrl;

}