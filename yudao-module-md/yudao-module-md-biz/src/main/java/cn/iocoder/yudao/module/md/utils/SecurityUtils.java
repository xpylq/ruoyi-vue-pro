package cn.iocoder.yudao.module.md.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecurityUtils {

    public static void main(String[] args) {
        generateAesKey();
    }

    /**
     * 生成rsa算法的公私钥
     * 长度1024位
     */
    public static void generateRsaKey(){
        RSA rsa = new RSA();
        System.out.println(rsa.getPrivateKeyBase64());
        System.out.println(rsa.getPublicKeyBase64());
    }

    public static void generateAesKey(){
        KeyUtil.generateKey("AES", 256).toString();
    }

    /**
     * aes 测试用例
     */
    public static void aesTest(){
        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        // 构建
        AES aes = SecureUtil.aes(key);
         aes = new AES("CBC", "PKCS7Padding",
                // 密钥，可以自定义
                "O55CUYzyDe4ZW3".getBytes(),
                // iv加盐，按照实际需求添加
                "i43mHD6ceMC0Hd".getBytes());

    }
}
