package cn.iocoder.yudao.module.park.dal.mysql.rent;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.park.dal.dataobject.rent.RentInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.park.controller.admin.rent.vo.*;

/**
 * 车位租赁信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface RentInfoMapper extends BaseMapperX<RentInfoDO> {

    default PageResult<RentInfoDO> selectPage(RentInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RentInfoDO>()
                .eqIfPresent(RentInfoDO::getUserId, reqVO.getUserId())
                .eqIfPresent(RentInfoDO::getTitle, reqVO.getTitle())
                .eqIfPresent(RentInfoDO::getRenterType, reqVO.getRenterType())
                .eqIfPresent(RentInfoDO::getIsFixed, reqVO.getIsFixed())
                .eqIfPresent(RentInfoDO::getParkType, reqVO.getParkType())
                .eqIfPresent(RentInfoDO::getPrice, reqVO.getPrice())
                .eqIfPresent(RentInfoDO::getStatus, reqVO.getStatus())
                .eqIfPresent(RentInfoDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(RentInfoDO::getLongitude, reqVO.getLongitude())
                .eqIfPresent(RentInfoDO::getMobile, reqVO.getMobile())
                .eqIfPresent(RentInfoDO::getDetailAddress, reqVO.getDetailAddress())
                .eqIfPresent(RentInfoDO::getDescription, reqVO.getDescription())
                .betweenIfPresent(RentInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RentInfoDO::getId));
    }

}