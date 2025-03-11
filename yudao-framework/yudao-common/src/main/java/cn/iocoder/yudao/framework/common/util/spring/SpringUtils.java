package cn.iocoder.yudao.framework.common.util.spring;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;

import java.util.Arrays;
import java.util.Objects;

/**
 * Spring 工具类
 *
 * @author 芋道源码
 */
public class SpringUtils extends SpringUtil {

    /**
     * 是否为生产环境
     *
     * @return 是否生产环境
     */
    public static boolean isProd() {
        String activeProfile = getActiveProfile();
        return Objects.equals("prod", activeProfile);
    }

    /**
     * 是否有任意指定的环境
     */
    public static boolean hasAnyProfiles(String... profiles) {
        String[] activeProfiles = getActiveProfiles();
        return ArrayUtil.containsAny(activeProfiles, profiles);
    }


}
