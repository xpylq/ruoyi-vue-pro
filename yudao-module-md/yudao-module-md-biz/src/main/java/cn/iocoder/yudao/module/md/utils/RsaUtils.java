package cn.iocoder.yudao.module.md.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import lombok.extern.slf4j.Slf4j;

import java.security.KeyPair;

@Slf4j
public class RsaUtils {

    public static void main(String[] args) {
        RSA rsa = new RSA();
        System.out.println(rsa.getPrivateKeyBase64());
        System.out.println(rsa.getPublicKeyBase64());
    }

    public static void test1(String[] args) {
        RSA rsa = new RSA();
        MovieDO movieDO = new MovieDO();
        movieDO.setId(1234L);
        movieDO.setTitle("test");
        CommonResult commonResult = CommonResult.success(movieDO);
        String base64EncodeData = rsa.encryptBase64(JsonUtils.toJsonByte(commonResult), KeyType.PrivateKey);
        log.info("base64EncodeData:{}", base64EncodeData);
        byte[] base64DecodeData = Base64.decode(base64EncodeData);
        JsonUtils.parseObject(rsa.decrypt(base64DecodeData, KeyType.PublicKey), CommonResult.class);

    }

    public static void test2() {
        RSA rsa = new RSA();
        MovieDO movieDO = new MovieDO();
        movieDO.setId(1234L);
        movieDO.setTitle("test");
        CommonResult commonResult = CommonResult.success(movieDO);
        byte[] rsaEncryptData = rsa.encrypt(JsonUtils.toJsonString(commonResult.getData()), KeyType.PrivateKey);
        String base64EncodeData = Base64.encode(rsaEncryptData);
        log.info("rsaData:{}", rsaEncryptData.length);
        log.info("base64EncodeData:{}", base64EncodeData);
        byte[] base64DecodeData = Base64.decode(base64EncodeData);
        String rsaDecryptData = new String(rsa.decrypt(base64DecodeData, KeyType.PublicKey));
        log.info("base64DecodeData:{}", base64DecodeData.length);
        log.info("rsaDecryptData:{}", rsaDecryptData);
        JsonUtils.parseObject(rsaDecryptData, CommonResult.class);
    }
}
