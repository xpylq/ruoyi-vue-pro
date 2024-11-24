package cn.iocoder.yudao.module.md.service.movie;

import javax.validation.*;
import cn.iocoder.yudao.module.md.controller.admin.movie.vo.*;
import cn.iocoder.yudao.module.md.controller.app.vo.AppMoviePageReqVO;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 影片 Service 接口
 *
 * @author 芋道源码
 */
public interface MovieService {

    /**
     * 创建影片
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMovie(@Valid MovieSaveReqVO createReqVO);

    /**
     * 更新影片
     *
     * @param updateReqVO 更新信息
     */
    void updateMovie(@Valid MovieSaveReqVO updateReqVO);

    /**
     * 删除影片
     *
     * @param id 编号
     */
    void deleteMovie(Long id);

    /**
     * 获得影片
     *
     * @param id 编号
     * @return 影片
     */
    MovieDO getMovie(Long id);

    /**
     * 获得影片分页
     *
     * @param pageReqVO 分页查询
     * @return 影片分页
     */
    PageResult<MovieDO> getMoviePage(MoviePageReqVO pageReqVO);

    /**
     * 获得影片分页
     *
     * @param pageReqVO 分页查询
     * @return 影片分页
     */
    PageResult<MovieDO> getMoviePage(AppMoviePageReqVO pageReqVO);

}