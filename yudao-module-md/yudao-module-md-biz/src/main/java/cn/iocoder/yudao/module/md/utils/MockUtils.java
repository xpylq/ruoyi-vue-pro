package cn.iocoder.yudao.module.md.utils;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockUtils {
    public static final List<MovieDO> movieList = mockMovieList();

    public static MovieDO mockMovie() {
        return movieList.get(0);
    }

    public static MovieDO mockMovie(int index) {
        return movieList.get(index);
    }

    public static PageResult<MovieDO> mockMoviePage(PageParam pageParam) {
        PageResult<MovieDO> pageResult = new PageResult();
        pageResult.setTotal((long) movieList.size());
        int fromIndex = (pageParam.getPageNo() - 1) * pageParam.getPageSize();
        int toIndex = pageParam.getPageNo() * pageParam.getPageSize();
        pageResult.setList(movieList.subList(fromIndex, toIndex));
        return pageResult;
    }

    public static List<MovieDO> mockMovieList() {
        List<MovieDO> movieList = new ArrayList<>();
        // 创建30个MovieDO对象并加入List，填充真实电影数据
        movieList.add(new MovieDO(1L, "ref1", "星际穿越1", "科幻", "美国", "克里斯托弗·诺兰", 169 * 60, 500000L, "http://example.com/image1.jpg"));
        movieList.add(new MovieDO(2L, "ref2", "盗梦空间", "科幻", "美国", "克里斯托弗·诺兰", 148 * 60, 300000L, "http://example.com/image2.jpg"));
        movieList.add(new MovieDO(3L, "ref3", "复仇者联盟", "动作", "美国", "乔斯·韦登", 143 * 60, 500000L, "http://example.com/image3.jpg"));
        movieList.add(new MovieDO(4L, "ref4", "泰坦尼克号", "爱情", "美国", "詹姆斯·卡梅隆", 195 * 60, 1000000L, "http://example.com/image4.jpg"));
        movieList.add(new MovieDO(5L, "ref5", "这个杀手不太冷", "动作", "法国", "吕克·贝松", 110 * 60, 400000L, "http://example.com/image5.jpg"));
        movieList.add(new MovieDO(6L, "ref6", "肖申克的救赎", "剧情", "美国", "弗兰克·达拉本特", 142 * 60, 2000000L, "http://example.com/image6.jpg"));
        movieList.add(new MovieDO(7L, "ref7", "盗墓笔记", "冒险", "中国", "李骏", 125 * 60, 150000L, "http://example.com/image7.jpg"));
        movieList.add(new MovieDO(8L, "ref8", "阿凡达", "科幻", "美国", "詹姆斯·卡梅隆", 162 * 60, 2700000L, "http://example.com/image8.jpg"));
        movieList.add(new MovieDO(9L, "ref9", "指环王：王者归来", "奇幻", "新西兰", "彼得·杰克逊", 201 * 60, 1500000L, "http://example.com/image9.jpg"));
        movieList.add(new MovieDO(10L, "ref10", "黑客帝国", "科幻", "美国", "沃卓斯基姐弟", 136 * 60, 1200000L, "http://example.com/image10.jpg"));
        movieList.add(new MovieDO(11L, "ref11", "疯狂的石头", "喜剧", "中国", "宁浩", 99 * 60, 800000L, "http://example.com/image11.jpg"));
        movieList.add(new MovieDO(12L, "ref12", "加勒比海盗", "冒险", "美国", "戈尔·维宾斯基", 143 * 60, 1200000L, "http://example.com/image12.jpg"));
        movieList.add(new MovieDO(13L, "ref13", "美国队长", "动作", "美国", "乔·卢素", 147 * 60, 2000000L, "http://example.com/image13.jpg"));
        movieList.add(new MovieDO(14L, "ref14", "速度与激情", "动作", "美国", "罗伯·科恩", 106 * 60, 1800000L, "http://example.com/image14.jpg"));
        movieList.add(new MovieDO(15L, "ref15", "星际迷航", "科幻", "美国", "J·J·艾布拉姆斯", 127 * 60, 1300000L, "http://example.com/image15.jpg"));
        movieList.add(new MovieDO(16L, "ref16", "海上钢琴师", "剧情", "意大利", "朱塞佩·托纳多雷", 180 * 60, 900000L, "http://example.com/image16.jpg"));
        movieList.add(new MovieDO(17L, "ref17", "心灵捕手", "剧情", "美国", "格斯·范·桑特", 126 * 60, 600000L, "http://example.com/image17.jpg"));
        movieList.add(new MovieDO(18L, "ref18", "大话西游", "喜剧", "中国", "刘镇伟", 90 * 60, 500000L, "http://example.com/image18.jpg"));
        movieList.add(new MovieDO(19L, "ref19", "悬崖上的金鱼姬", "动画", "日本", "宫崎骏", 100 * 60, 400000L, "http://example.com/image19.jpg"));
        movieList.add(new MovieDO(20L, "ref20", "千与千寻", "动画", "日本", "宫崎骏", 125 * 60, 2500000L, "http://example.com/image20.jpg"));
        movieList.add(new MovieDO(21L, "ref21", "生死时速", "动作", "美国", "简·德·邦特", 116 * 60, 900000L, "http://example.com/image21.jpg"));
        movieList.add(new MovieDO(22L, "ref22", "教父", "剧情", "美国", "弗朗西斯·福特·科波拉", 175 * 60, 3000000L, "http://example.com/image22.jpg"));
        movieList.add(new MovieDO(23L, "ref23", "星际穿越2", "科幻", "美国", "克里斯托弗·诺兰", 169 * 60, 2000000L, "http://example.com/image23.jpg"));
        movieList.add(new MovieDO(24L, "ref24", "勇敢的心", "剧情", "美国", "梅尔·吉布森", 177 * 60, 1500000L, "http://example.com/image24.jpg"));
        movieList.add(new MovieDO(25L, "ref25", "绿皮书", "剧情", "美国", "彼得·法雷里", 130 * 60, 500000L, "http://example.com/image25.jpg"));
        movieList.add(new MovieDO(26L, "ref26", "辛德勒的名单", "剧情", "美国", "史蒂文·斯皮尔伯格", 195 * 60, 4000000L, "http://example.com/image26.jpg"));
        movieList.add(new MovieDO(27L, "ref27", "勇敢者游戏", "冒险", "美国", "乔·庄斯顿", 104 * 60, 600000L, "http://example.com/image27.jpg"));
        movieList.add(new MovieDO(28L, "ref28", "蜘蛛侠", "动作", "美国", "山姆·雷米", 121 * 60, 2000000L, "http://example.com/image28.jpg"));
        movieList.add(new MovieDO(29L, "ref29", "冰雪奇缘", "动画", "美国", "克里斯·巴克", 102 * 60, 3000000L, "http://example.com/image29.jpg"));
        movieList.add(new MovieDO(30L, "ref30", "玩具总动员", "动画", "美国", "约翰·拉塞特", 81 * 60, 3500000L, "http://example.com/image30.jpg"));
        movieList.forEach(movieDO -> {
            movieDO.setCreateTime(LocalDateTime.now());
            movieDO.setCreator("system");
            movieDO.setDeleted(false);
        });
        return movieList;
    }
}
