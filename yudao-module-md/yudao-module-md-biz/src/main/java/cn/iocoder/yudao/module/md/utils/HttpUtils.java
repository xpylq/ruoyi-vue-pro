package cn.iocoder.yudao.module.md.utils;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public class HttpUtils {

    private static CloseableHttpClient httpClient;


    public static synchronized CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = HttpClients.createDefault();
        }
        return httpClient;
    }
}
