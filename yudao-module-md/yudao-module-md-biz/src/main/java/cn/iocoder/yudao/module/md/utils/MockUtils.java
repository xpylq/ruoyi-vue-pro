package cn.iocoder.yudao.module.md.utils;

import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;

import java.time.LocalDateTime;

public class MockUtils {

    public static MovieDO mockMovie() {
        MovieDO movie = new MovieDO();
        movie.setId(1L);
        movie.setRefId("ref123456");
        movie.setTitle("星际穿越");
        movie.setType("科幻");
        movie.setArea("美国");
        movie.setAuthor("克里斯托弗·诺兰");
        movie.setDuration(169 * 60);
        movie.setViewTimes(50000L);
        movie.setImageUrl("http://example.com/image.jpg");
        movie.setCreateTime(LocalDateTime.now());
        movie.setCreator("system");
        movie.setDeleted(false);
        return movie;
    }
}
