package cn.iocoder.yudao.module.md.controller.app.movie;


import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.RSA;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.framework.encrypt.RsaComponent;
import cn.iocoder.yudao.framework.encrypt.core.annotation.ApiEncrypt;
import cn.iocoder.yudao.framework.ratelimiter.core.annotation.RateLimiter;
import cn.iocoder.yudao.framework.ratelimiter.core.keyresolver.impl.MDLimiterKeyResolver;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import cn.iocoder.yudao.module.md.utils.HttpUtils;
import cn.iocoder.yudao.module.md.utils.MockUtils;
import com.esotericsoftware.minlog.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Slf4j
@Tag(name = "APP-MD-测试")
@RestController
@RequestMapping("/md/test")
@Validated
public class TestController {
    @Autowired
    private RsaComponent rsaComponent;

    private CloseableHttpClient httpClient = HttpUtils.getHttpClient();


    @PermitAll
    @GetMapping("/limit")
    @Operation(summary = "限流测试")
    @RateLimiter(count = 1, keyResolver = MDLimiterKeyResolver.class)
    public CommonResult<String> getMoviePage() {
        return success("");
    }

    @PermitAll
    @GetMapping("/hsex")
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

    @PermitAll
    @RateLimiter(count = 1, keyResolver = MDLimiterKeyResolver.class)
    @GetMapping("/encrypt")
    public CommonResult<MovieDO> noEncrypt() {
        MovieDO movie = MockUtils.mockMovie();
        String encryptData = rsaComponent.encrypt(MockUtils.mockMovie());
        log.info("待加密:{}", JsonUtils.toJsonString(movie));
        log.info("加密后:{}", encryptData);
        log.info("解密:{}", JsonUtils.toJsonString(rsaComponent.decrypt(encryptData, MovieDO.class)));
        return success(movie, encryptData);
    }

    @PermitAll
    @ApiEncrypt
    @RateLimiter(count = 1, keyResolver = MDLimiterKeyResolver.class)
    @GetMapping("/apiEncrypt")
    public CommonResult<MovieDO> encrypt() {
        MovieDO movie = MockUtils.mockMovie();
        return success(movie);
    }



}
