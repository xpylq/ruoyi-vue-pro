package cn.iocoder.yudao.module.md.service.movie;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.md.controller.admin.movie.vo.MoviePageReqVO;
import cn.iocoder.yudao.module.md.controller.admin.movie.vo.MovieSaveReqVO;
import cn.iocoder.yudao.module.md.controller.app.vo.AppMoviePageReqVO;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import cn.iocoder.yudao.module.md.dal.mysql.movie.MovieMapper;
import cn.iocoder.yudao.module.md.enums.ErrorCodeConstants;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 影片 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MovieServiceImpl implements MovieService {

    @Resource
    private MovieMapper movieMapper;

    @Override
    public Long createMovie(MovieSaveReqVO createReqVO) {
        // 插入
        MovieDO movie = BeanUtils.toBean(createReqVO, MovieDO.class);
        movieMapper.insert(movie);
        // 返回
        return movie.getId();
    }

    @Override
    public void updateMovie(MovieSaveReqVO updateReqVO) {
        // 校验存在
        validateMovieExists(updateReqVO.getId());
        // 更新
        MovieDO updateObj = BeanUtils.toBean(updateReqVO, MovieDO.class);
        movieMapper.updateById(updateObj);
    }

    @Override
    public void deleteMovie(Long id) {
        // 校验存在
        validateMovieExists(id);
        // 删除
        movieMapper.deleteById(id);
    }

    private void validateMovieExists(Long id) {
        if (movieMapper.selectById(id) == null) {
            throw exception(ErrorCodeConstants.MOVIE_NOT_EXISTS);
        }
    }

    @Override
    public MovieDO getMovie(Long id) {
        return movieMapper.selectById(id);
    }

    @Override
    public PageResult<MovieDO> getMoviePage(MoviePageReqVO pageReqVO) {
        return movieMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<MovieDO> getMoviePage(AppMoviePageReqVO pageReqVO) {
        return movieMapper.selectPage(pageReqVO);
    }
}