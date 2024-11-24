package cn.iocoder.yudao.module.md.dal.mysql.movie;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.md.controller.admin.movie.vo.*;

/**
 * 影片 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MovieMapper extends BaseMapperX<MovieDO> {

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

}