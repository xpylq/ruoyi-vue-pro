package cn.iocoder.yudao.framework.encrypt.aop;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.framework.encrypt.annotation.ApiEncrypt;
import cn.iocoder.yudao.framework.encrypt.config.ApiEncryptProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * API接口AES加解密切面
 * 接口入参解密
 * 接口返回加密
 */
@Slf4j
@Aspect
public class ApiEncryptAspect {
    private final RSA rsa;

    @Autowired
    private ApiEncryptProperties properties;

    public ApiEncryptAspect(ApiEncryptProperties properties) {
        this.properties = properties;
        rsa = new RSA(properties.getRsaPrivateKey(), properties.getRsaPublicKey());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Around(value = "@annotation(encrypt)")
    public Object afterPointCut(ProceedingJoinPoint joinPoint, ApiEncrypt encrypt) {
        Object result = null;
        String encryptData = StrUtil.EMPTY;
        boolean isCommonResult = false;
        try {
            result = joinPoint.proceed();
            if (CommonResult.class.isAssignableFrom(result.getClass())) {
                isCommonResult = true;
                CommonResult commonResult = (CommonResult) result;
                if (null != commonResult.getData()) {
                    encryptData = rsa.encryptBase64(JsonUtils.toJsonByte(commonResult.getData()), KeyType.PublicKey);
                }
            }
        } catch (Throwable e) {
            log.error("接口请求加密失败，error={}", e.getMessage(), e);
        }
        if (isCommonResult && StrUtil.isNotBlank(encryptData)) {
            ((CommonResult) result).setData(encryptData);
        }
        return result;
    }
}
