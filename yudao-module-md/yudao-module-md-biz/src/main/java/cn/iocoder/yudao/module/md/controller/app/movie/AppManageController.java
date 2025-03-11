package cn.iocoder.yudao.module.md.controller.app.movie;


import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.ratelimiter.core.annotation.RateLimiter;
import cn.iocoder.yudao.framework.ratelimiter.core.keyresolver.impl.MDLimiterKeyResolver;
import cn.iocoder.yudao.module.md.dal.redis.movie.MovieRedisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/md/manage")
@Validated
public class AppManageController {
    @Autowired
    private MovieRedisDAO movieRedisDAO;

    /**
     * /app-api/md/manage/clearCache?token=m393K1FjPVPgoc
     */
    @GetMapping("/clearCache")
    @PermitAll
    @RateLimiter(count = 1, keyResolver = MDLimiterKeyResolver.class)
    public CommonResult<String> getMoviePage(String token) {
        if ("m393K1FjPVPgoc".equals(token)) {
            movieRedisDAO.clearAll();
        }
        return CommonResult.success("");
    }
}
