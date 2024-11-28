package cn.iocoder.yudao.framework.encrypt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

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
}
