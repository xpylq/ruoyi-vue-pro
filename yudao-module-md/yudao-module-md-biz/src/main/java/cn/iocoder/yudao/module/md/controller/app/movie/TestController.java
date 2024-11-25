package cn.iocoder.yudao.module.md.controller.app.movie;


import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.ratelimiter.core.annotation.RateLimiter;
import cn.iocoder.yudao.framework.ratelimiter.core.keyresolver.impl.ClientIpRateLimiterKeyResolver;
import cn.iocoder.yudao.framework.ratelimiter.core.keyresolver.impl.MDLimiterKeyResolver;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @GetMapping("/limit")
    @Operation(summary = "限流测试")
    @PermitAll
    @RateLimiter(count = 1, keyResolver = MDLimiterKeyResolver.class)
    public CommonResult<String> getMoviePage(long id) {
        return success("");
    }
}
