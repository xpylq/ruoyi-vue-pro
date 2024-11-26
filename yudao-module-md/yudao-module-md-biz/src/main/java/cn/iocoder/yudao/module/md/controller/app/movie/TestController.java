package cn.iocoder.yudao.module.md.controller.app.movie;


import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.ratelimiter.core.annotation.RateLimiter;
import cn.iocoder.yudao.framework.ratelimiter.core.keyresolver.impl.MDLimiterKeyResolver;
import cn.iocoder.yudao.module.md.utils.HttpUtils;
import com.esotericsoftware.minlog.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "APP-MD-测试")
@RestController
@RequestMapping("/md/test")
@Validated
public class TestController {

    private CloseableHttpClient httpClient = HttpUtils.getHttpClient();

    @GetMapping("/limit")
    @Operation(summary = "限流测试")
    @RateLimiter(count = 1, keyResolver = MDLimiterKeyResolver.class)
    public CommonResult<String> getMoviePage() {
        return success("");
    }

    @GetMapping("/hsex")
    @PermitAll
    public CommonResult<String> hsex(String id) {
        try {
            String url = StrUtil.format("https://hsex.men/video-{}.htm", id);
            CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
            Log.info(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success("");
    }
}
