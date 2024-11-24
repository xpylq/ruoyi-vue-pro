package cn.iocoder.yudao.module.madou.service.movie;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.madou.controller.admin.movie.vo.*;
import cn.iocoder.yudao.module.madou.dal.dataobject.movie.MovieDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.madou.dal.mysql.movie.MovieMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.madou.enums.ErrorCodeConstants.*;

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
            throw exception(MOVIE_NOT_EXISTS);
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

}