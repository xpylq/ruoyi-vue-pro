package cn.iocoder.yudao.module.park.enums;// TODO 待办：请将下面的错误码复制到 yudao-module-park-api 模块的 ErrorCodeConstants 类中。注意，请给“TODO 补充编号”设置一个错误码编号！！！

import cn.iocoder.yudao.framework.common.exception.ErrorCode;


/**
 * park 错误码枚举类
 * <p>
 * park 系统，使用 1-100-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 车位租赁信息 1-100-001-000 ==========
    ErrorCode RENT_INFO_NOT_EXISTS = new ErrorCode(1 - 100 - 001 - 001, "车位租赁信息不存在");
}