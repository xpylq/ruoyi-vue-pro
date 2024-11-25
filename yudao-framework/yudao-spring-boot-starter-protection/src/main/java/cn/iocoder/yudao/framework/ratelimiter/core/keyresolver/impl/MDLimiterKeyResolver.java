package cn.iocoder.yudao.framework.ratelimiter.core.keyresolver.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.iocoder.yudao.framework.common.util.servlet.ServletUtils;
import cn.iocoder.yudao.framework.ratelimiter.core.annotation.RateLimiter;
import cn.iocoder.yudao.framework.ratelimiter.core.keyresolver.RateLimiterKeyResolver;
import org.aspectj.lang.JoinPoint;

/**
 * 自定义限流器
 * IP+方法名限流（不包含参数）
 */
public class MDLimiterKeyResolver implements RateLimiterKeyResolver {
    @Override
    public String resolver(JoinPoint joinPoint, RateLimiter rateLimiter) {
        String methodName = joinPoint.getSignature().toString();
        String clientIp = ServletUtils.getClientIP();
        return SecureUtil.md5(methodName + clientIp);
    }
}
