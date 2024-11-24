package cn.iocoder.yudao.module.md.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HSexUtils {
    public static String BASE_URL_TEMPLATE = "https://hsex.men/video-{}.htm";

    public static String parseVideoUrl(String refId) {
        String url = StrUtil.format(BASE_URL_TEMPLATE, refId);
        HttpUtil.get(url);
        String pageContent = HttpUtil.get(url);
        if (StrUtil.isNotBlank(pageContent)) {
            // 解析页面内容
            Document document = Jsoup.parse(pageContent);
            String videoUrl= document.selectXpath("//video/source").first().attr("src");
            return videoUrl.replace("cdn.hsex.tv","cdn.bigcloud.click");
        }
        return StrUtil.EMPTY;
    }
}
