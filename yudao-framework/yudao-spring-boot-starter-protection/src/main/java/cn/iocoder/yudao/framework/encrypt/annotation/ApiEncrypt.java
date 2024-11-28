package cn.iocoder.yudao.framework.encrypt.annotation;


import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiEncrypt {
}
