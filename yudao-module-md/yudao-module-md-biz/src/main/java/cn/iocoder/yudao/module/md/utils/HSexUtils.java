package cn.iocoder.yudao.module.md.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HSexUtils {
    // 定义正则表达式
    public static final String IMAGE_URL_REGEX = "url\\(['\"]?(.*?)['\"]?\\)";
    // 创建Pattern对象
    public static final Pattern pattern = Pattern.compile(IMAGE_URL_REGEX);

    public static String BASE_URL_TEMPLATE = "https://hsex.men/video-{}.htm";

    public static String parseVideoUrl(String refId) {
        String url = StrUtil.format(BASE_URL_TEMPLATE, refId);
        String pageContent = HttpUtil.get(url);
        if (StrUtil.isNotBlank(pageContent)) {
            // 解析页面内容
            Document document = Jsoup.parse(pageContent);
            String videoUrl = document.selectXpath("//video/source").first().attr("src");
            return videoUrl.replace("cdn.hsex.tv", "cdn.bigcloud.click");
        }
        return StrUtil.EMPTY;
    }


    public static String parseImageUrl(String styleStr) {
        // 创建Matcher对象
        Matcher matcher = pattern.matcher(styleStr);
        if (matcher.find()) {
            String url = matcher.group(1); // 提取括号内的内容
            return url;
        } else {
            return null;
        }
    }

    public static int parseDuration(String str) {
        String fullTime = "00:" + str;
        // 将时间字符串格式化为 HH:mm:ss 中的 mm:ss 格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(fullTime, formatter); // 解析时间

        // 使用 LocalTime 提取总秒数
        return localTime.getMinute() * 60 + localTime.getSecond();
    }

    public static long parseViewTimes(String str) {
        // 正则表达式提取数字部分
        String numberStr = str.replaceAll("[^0-9\\.kKmM]", ""); // 只保留数字、小数点和 k/m
        double baseNumber;
        if (numberStr.toLowerCase().endsWith("k")) {
            // 如果以 'k' 结尾，表示千，转换为实际数字
            baseNumber = Double.parseDouble(numberStr.substring(0, numberStr.length() - 1)) * 1000;
        } else if (numberStr.toLowerCase().endsWith("m")) {
            // 如果以 'm' 结尾，表示百万，转换为实际数字
            baseNumber = Double.parseDouble(numberStr.substring(0, numberStr.length() - 1)) * 1_000_000;
        } else {
            // 如果没有单位，直接转换
            baseNumber = Double.parseDouble(numberStr);
        }
        return (long) baseNumber;
    }
}
