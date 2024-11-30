package cn.iocoder.yudao.framework.encrypt.config;

import cn.hutool.crypto.asymmetric.RSA;
import cn.iocoder.yudao.framework.encrypt.RsaComponent;
import cn.iocoder.yudao.framework.encrypt.core.aop.ApiEncryptAspect;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@EnableConfigurationProperties(ApiEncryptProperties.class)
public class YudaoApiEncryptAspectAutoConfiguration {

    @Bean
    public RsaComponent rsa(ApiEncryptProperties properties) {
        return new RsaComponent(properties);
    }


    @Bean
    public ApiEncryptAspect apiEncryptAspect(RsaComponent rsaComponent) {
        return new ApiEncryptAspect(rsaComponent);
    }

}
