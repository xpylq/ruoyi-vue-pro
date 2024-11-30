package cn.iocoder.yudao.framework.encrypt;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.framework.encrypt.config.ApiEncryptProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RsaComponent {

    private final ApiEncryptProperties properties;

    private final RSA rsa;

    public RsaComponent(ApiEncryptProperties properties) {
        this.properties = properties;
        this.rsa = new RSA(properties.getRsaPrivateKey(), properties.getRsaPublicKey());
    }

    public String encrypt(Object data) {
        String encryptData = StrUtil.EMPTY;
        if (null != data) {
            try {
                encryptData = rsa.encryptBase64(JsonUtils.toJsonByte(data), KeyType.PublicKey);
            } catch (Exception e) {
                log.error("[RSA] 加密失败，error={}", e.getMessage(), e);
            }
        }
        return encryptData;
    }

    public <T> T decrypt(String data, Class<T> clazz) {
        T decryptData = null;
        if (StrUtil.isNotBlank(data)) {
            decryptData = JsonUtils.parseObject(rsa.decrypt(Base64.decode(data), KeyType.PrivateKey), clazz);
        }
        return decryptData;
    }
}
