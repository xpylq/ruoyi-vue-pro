package cn.iocoder.yudao.framework.encrypt.config;

import cn.iocoder.yudao.framework.encrypt.aop.ApiEncryptAspect;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@EnableConfigurationProperties(ApiEncryptProperties.class)
public class YudaoApiEncryptAspectAutoConfiguration {

    @Bean
    public ApiEncryptAspect apiEncryptAspect(ApiEncryptProperties apiEncryptProperties) {
        return new ApiEncryptAspect(apiEncryptProperties);
    }

}
