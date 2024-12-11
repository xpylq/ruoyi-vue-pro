package cn.iocoder.yudao.framework.encrypt;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.framework.encrypt.config.ApiEncryptProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AesComponent {

    private final ApiEncryptProperties properties;

    private final AES aes;

    public AesComponent(ApiEncryptProperties properties) {
        this.properties = properties;
        this.aes = new AES("CBC", "PKCS7Padding",
                properties.getAesKey().getBytes(), properties.getAesIv().getBytes());
    }

    public String encrypt(Object data) {
        String encryptData = StrUtil.EMPTY;
        if (null != data) {
            try {
                encryptData = aes.encryptBase64(JsonUtils.toJsonByte(data));
            } catch (Exception e) {
                log.error("[AES] 加密失败，error={}", e.getMessage(), e);
            }
        }
        return encryptData;
    }

    public <T> T decrypt(String data, Class<T> clazz) {
        T decryptData = null;
        if (StrUtil.isNotBlank(data)) {
            decryptData = JsonUtils.parseObject(aes.decryptStr(data), clazz);
        }
        return decryptData;
    }
}
