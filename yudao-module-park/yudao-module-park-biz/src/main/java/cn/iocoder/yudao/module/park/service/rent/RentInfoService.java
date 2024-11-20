package cn.iocoder.yudao.module.park.service.rent;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.park.controller.admin.rent.vo.*;
import cn.iocoder.yudao.module.park.dal.dataobject.rent.RentInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 车位租赁信息 Service 接口
 *
 * @author 芋道源码
 */
public interface RentInfoService {

    /**
     * 创建车位租赁信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRentInfo(@Valid RentInfoSaveReqVO createReqVO);

    /**
     * 更新车位租赁信息
     *
     * @param updateReqVO 更新信息
     */
    void updateRentInfo(@Valid RentInfoSaveReqVO updateReqVO);

    /**
     * 删除车位租赁信息
     *
     * @param id 编号
     */
    void deleteRentInfo(Long id);

    /**
     * 获得车位租赁信息
     *
     * @param id 编号
     * @return 车位租赁信息
     */
    RentInfoDO getRentInfo(Long id);

    /**
     * 获得车位租赁信息分页
     *
     * @param pageReqVO 分页查询
     * @return 车位租赁信息分页
     */
    PageResult<RentInfoDO> getRentInfoPage(RentInfoPageReqVO pageReqVO);

}