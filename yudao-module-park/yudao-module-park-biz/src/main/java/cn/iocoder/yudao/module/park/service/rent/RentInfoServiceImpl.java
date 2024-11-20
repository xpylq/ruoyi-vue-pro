package cn.iocoder.yudao.module.park.service.rent;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.park.controller.admin.rent.vo.*;
import cn.iocoder.yudao.module.park.dal.dataobject.rent.RentInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.park.dal.mysql.rent.RentInfoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.park.enums.ErrorCodeConstants.*;

/**
 * 车位租赁信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class RentInfoServiceImpl implements RentInfoService {

    @Resource
    private RentInfoMapper rentInfoMapper;

    @Override
    public Long createRentInfo(RentInfoSaveReqVO createReqVO) {
        // 插入
        RentInfoDO rentInfo = BeanUtils.toBean(createReqVO, RentInfoDO.class);
        rentInfoMapper.insert(rentInfo);
        // 返回
        return rentInfo.getId();
    }

    @Override
    public void updateRentInfo(RentInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateRentInfoExists(updateReqVO.getId());
        // 更新
        RentInfoDO updateObj = BeanUtils.toBean(updateReqVO, RentInfoDO.class);
        rentInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteRentInfo(Long id) {
        // 校验存在
        validateRentInfoExists(id);
        // 删除
        rentInfoMapper.deleteById(id);
    }

    private void validateRentInfoExists(Long id) {
        if (rentInfoMapper.selectById(id) == null) {
            throw exception(RENT_INFO_NOT_EXISTS);
        }
    }

    @Override
    public RentInfoDO getRentInfo(Long id) {
        return rentInfoMapper.selectById(id);
    }

    @Override
    public PageResult<RentInfoDO> getRentInfoPage(RentInfoPageReqVO pageReqVO) {
        return rentInfoMapper.selectPage(pageReqVO);
    }

}