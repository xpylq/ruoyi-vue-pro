package cn.iocoder.yudao.module.md.dal.mysql.movie;

import cn.hutool.core.date.DateUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.date.DateUtils;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.md.controller.app.movie.vo.AppMoviePageReqVO;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.md.controller.admin.movie.vo.*;

/**
 * 影片 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MovieMapper extends BaseMapperX<MovieDO> {

    default MovieDO fetchByRefId(String refId) {
        QueryWrapper<MovieDO> wrapper = new QueryWrapper<>();
        wrapper.eq("ref_id", refId);
        return this.selectOne(wrapper, false);
    }

    default PageResult<MovieDO> selectPage(MoviePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MovieDO>()
                .eqIfPresent(MovieDO::getRefId, reqVO.getRefId())
                .likeIfPresent(MovieDO::getTitle, reqVO.getTitle())
                .eqIfPresent(MovieDO::getType, reqVO.getType())
                .eqIfPresent(MovieDO::getArea, reqVO.getArea())
                .eqIfPresent(MovieDO::getAuthor, reqVO.getAuthor())
                .betweenIfPresent(MovieDO::getDuration, reqVO.getDuration())
                .geIfPresent(MovieDO::getViewTimes, reqVO.getViewTimes())
                .betweenIfPresent(MovieDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MovieDO::getId));
    }

    default PageResult<MovieDO> selectPage(AppMoviePageReqVO reqVO) {
        LambdaQueryWrapperX<MovieDO> query = new LambdaQueryWrapperX<MovieDO>()
                .likeIfPresent(MovieDO::getTitle, reqVO.getTitle())
                .eqIfPresent(MovieDO::getType, reqVO.getType())
                .eqIfPresent(MovieDO::getArea, reqVO.getArea())
                .eqIfPresent(MovieDO::getAuthor, reqVO.getAuthor());
        // 时间范围类型(week:每周,month:每月,all:历史)
        if ("week".equals(reqVO.getTimeRangeType())) {
            query.gt(MovieDO::getCreateTime, DateUtil.beginOfWeek(DateUtil.date()));
        } else if ("month".equals(reqVO.getTimeRangeType())) {
            query.gt(MovieDO::getCreateTime, DateUtil.beginOfMonth(DateUtil.date()));
        }
        // 排序类型（hot:热门，time:最新）
        if ("hot".equals(reqVO.getOrderType())) {
            query.orderByDesc(MovieDO::getViewTimes);
        } else if ("time".equals(reqVO.getOrderType())) {
            query.orderByDesc(MovieDO::getCreateTime);
        } else {
            query.orderByDesc(MovieDO::getViewTimes);
        }
        return selectPage(reqVO, query);

    }

}