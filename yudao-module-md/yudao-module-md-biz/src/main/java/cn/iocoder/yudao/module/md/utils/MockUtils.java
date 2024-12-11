package cn.iocoder.yudao.module.md.utils;

import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;

import java.time.LocalDateTime;

public class MockUtils {

    public static MovieDO mockMovie1() {
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
    public static MovieDO mockMovie2() {
        MovieDO movie = new MovieDO();
        movie.setId(2L);
        movie.setRefId("ref123457");
        movie.setTitle("盗梦空间");
        movie.setType("科幻");
        movie.setArea("美国");
        movie.setAuthor("克里斯托弗·诺兰");
        movie.setDuration(148 * 60);  // 时长为 148 分钟
        movie.setViewTimes(120000L);  // 观看次数
        movie.setImageUrl("http://example.com/image2.jpg");
        movie.setCreateTime(LocalDateTime.now().minusDays(1));  // 创建时间稍微早一些
        movie.setCreator("system");
        movie.setDeleted(false);
        return movie;
    }
    public static MovieDO mockMovie3() {
        MovieDO movie = new MovieDO();
        movie.setId(3L);
        movie.setRefId("ref123458");
        movie.setTitle("银河系漫游指南");
        movie.setType("科幻");
        movie.setArea("英国");
        movie.setAuthor("道格拉斯·亚当斯");
        movie.setDuration(109 * 60);  // 时长为 109 分钟
        movie.setViewTimes(25000L);   // 观看次数
        movie.setImageUrl("http://example.com/image3.jpg");
        movie.setCreateTime(LocalDateTime.now().minusDays(2));  // 创建时间稍微再早一些
        movie.setCreator("system");
        movie.setDeleted(false);
        return movie;
    }
}
