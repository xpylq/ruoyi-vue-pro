package cn.iocoder.yudao.module.madou.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * MD 错误码枚举类
 *
 * MD 系统，使用 1-100-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== movie 模块 1-100-000-000 ==========
    ErrorCode MOVIE_NOT_EXISTS = new ErrorCode(1_100_000_000, "影片不存在");

}
