package cn.iocoder.yudao.module.md.service.job;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import cn.iocoder.yudao.module.md.dal.mysql.movie.MovieMapper;
import cn.iocoder.yudao.module.md.utils.HSexUtils;
import cn.iocoder.yudao.module.md.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HsexJobService {
    public static final String BASE_URL = "https://hsex.men";

    private CloseableHttpClient httpClient = HttpUtils.getHttpClient();

    @Autowired
    private MovieMapper movieMapper;

    /**
     * 周TOP
     * https://hsex.men//top7_list-1.htm
     */
    public void processWeekTop(int totalPage) {
        String urlTemplate = BASE_URL + "/top7_list-{}.htm";
        processList(urlTemplate, totalPage);
    }

    /**
     * 月TOP
     * https://hsex.men/top_list-1.htm
     */
    public void processMonthTop(int totalPage) {
        String urlTemplate = BASE_URL + "/top_list-{}.htm";
        processList(urlTemplate, totalPage);
    }

    /**
     * 历史TOP
     * https://hsex.men/list-1.htm?sort=hot
     */
    public void processHistoryTop(int totalPage) {
        String urlTemplate = BASE_URL + "/list-{}.htm?sort=hot";
        processList(urlTemplate, totalPage);
    }

    /**
     * 爬取列表
     */
    public void processList(String urlTemplate, int totalPage) {
        for (int page = 1; page <= totalPage; page++) {
            String url = StrUtil.format(urlTemplate, page);
            try {
                CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
                log.info("hsex processing currentPage={}", page);
                if (response.getCode() == 200 && response.getEntity() != null) {
                    // 解析页面内容
                    Document document = Jsoup.parse(EntityUtils.toString(response.getEntity()));
                    document.selectXpath("//div[@class='thumbnail']").stream().forEach(element -> {
                        try {
                            String detailUrl = element.selectXpath(".//a").first().attr("href");
                            String refId = detailUrl.split("-")[1].replace(".htm", "");
                            String title = element.selectXpath("div[@class='caption title']").text();
                            String author = element.selectXpath(".//div[@class='info']/p/a").text();
                            String info = element.selectXpath(".//div[@class='info']").text();
                            String[] infos = info.replace(author, StrUtil.EMPTY).trim().split(" ");
                            long viewTimes = HSexUtils.parseViewTimes(infos[0]);
                            String duration = element.selectXpath(".//var[@class='duration']").first().text();
                            String imageUrl = HSexUtils.parseImageUrl(element.selectXpath(".//div[@class='image']").attr("style"));
                            MovieDO movie = movieMapper.fetchByRefId(refId);
                            if (movie == null) {
                                MovieDO tmp = new MovieDO();
                                tmp.setTitle(title);
                                tmp.setAuthor(author);
                                tmp.setDuration(HSexUtils.parseDuration(duration));
                                tmp.setImageUrl(imageUrl);
                                tmp.setRefId(refId);
                                tmp.setViewTimes(viewTimes);
                                tmp.setType("self");
                                tmp.setArea("asia");
                                movieMapper.insert(tmp);
                                log.info("hsex insert, refId: {}, title: {}, author: {}, duration: {}, imageUrl: {}", refId, title, author, duration, imageUrl);
                            }
                        } catch (Exception e) {
                            log.error("hsex fail, url: {}, e: {}", url, e.getMessage(), e);
                        }
                    });
                }
                Thread.sleep(RandomUtil.randomInt(1000, 10000));
            } catch (Exception e) {
                log.error("hsex fail, url: {}, e: {}", url, e.getMessage(), e);
            }
        }
    }
}
