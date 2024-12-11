package cn.iocoder.yudao.framework.encrypt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Validated
@ConfigurationProperties(prefix = "yudao.api-encrypt")
public class ApiEncryptProperties {

    /**
     * RSA 私钥
     */
    @NotEmpty(message = "RSA 私钥")
    private String rsaPrivateKey;

    /**
     * RSA 公钥
     */
    @NotEmpty(message = "RSA 公钥")
    private String rsaPublicKey;

    /**
     * RSA 秘钥
     */
    @NotEmpty(message = "AES 秘钥")
    private String aesKey;

    /**
     * RSA 盐
     */
    @NotEmpty(message = "AES 盐")
    private String aesIv;
}
