package cn.iocoder.yudao.framework.encrypt.core.annotation;


import cn.iocoder.yudao.framework.encrypt.core.enums.AlgorithmType;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiEncrypt {

    /**
     * 接口加密的算法类型，默认AES
     */
    AlgorithmType type() default AlgorithmType.AES;

}
