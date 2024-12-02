package cn.iocoder.yudao.module.md.dal.redis;


/**
 * System Redis Key 枚举类
 *
 * @author 芋道源码
 */
public interface RedisKeyConstants {

    /**
     * 电影播放地址缓存
     * <p>
     * KEY 格式：movie_video_url:{id}
     */
    String MOVIE_VIDEO_URL = "movie_video_url";
}
