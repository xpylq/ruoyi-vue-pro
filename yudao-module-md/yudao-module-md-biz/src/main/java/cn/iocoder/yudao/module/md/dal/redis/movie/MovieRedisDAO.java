package cn.iocoder.yudao.module.md.dal.redis.movie;

import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.md.controller.admin.movie.vo.MovieRespVO;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import cn.iocoder.yudao.module.md.dal.mysql.movie.MovieMapper;
import cn.iocoder.yudao.module.md.dal.redis.RedisKeyConstants;
import cn.iocoder.yudao.module.md.utils.HSexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRedisDAO {
    @Autowired
    private MovieMapper movieMapper;

    @Cacheable(value = RedisKeyConstants.MOVIE_VIDEO_URL + "#1800", key = "#id", unless = "#result.videoUrl == null || #result.videoUrl.isEmpty()")
    public MovieRespVO getById(String id) {
        MovieRespVO movieRespVO = null;
        MovieDO movie = movieMapper.selectById(id);
        if (movie != null) {
            movieRespVO = BeanUtils.toBean(movie, MovieRespVO.class);
            movieRespVO.setVideoUrl(HSexUtils.parseVideoUrl(movie.getRefId()));
        }
        return movieRespVO;
    }

    @CacheEvict(value = RedisKeyConstants.MOVIE_VIDEO_URL, allEntries = true)
    public void clearAll() {

    }

}
