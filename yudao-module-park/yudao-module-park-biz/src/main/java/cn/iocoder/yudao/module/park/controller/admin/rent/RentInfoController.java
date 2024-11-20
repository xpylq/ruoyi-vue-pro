package cn.iocoder.yudao.module.park.controller.admin.rent;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.park.controller.admin.rent.vo.RentInfoPageReqVO;
import cn.iocoder.yudao.module.park.controller.admin.rent.vo.RentInfoRespVO;
import cn.iocoder.yudao.module.park.controller.admin.rent.vo.RentInfoSaveReqVO;
import cn.iocoder.yudao.module.park.dal.dataobject.rent.RentInfoDO;
import cn.iocoder.yudao.module.park.service.rent.RentInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "管理后台 - 车位租赁信息")
@RestController
@RequestMapping("/park/rent-info")
@Validated
public class RentInfoController {

    @Resource
    private RentInfoService rentInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建车位租赁信息")
    @PreAuthorize("@ss.hasPermission('park:rent-info:create')")
    public CommonResult<Long> createRentInfo(@Valid @RequestBody RentInfoSaveReqVO createReqVO) {
        return success(rentInfoService.createRentInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新车位租赁信息")
    @PreAuthorize("@ss.hasPermission('park:rent-info:update')")
    public CommonResult<Boolean> updateRentInfo(@Valid @RequestBody RentInfoSaveReqVO updateReqVO) {
        rentInfoService.updateRentInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除车位租赁信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('park:rent-info:delete')")
    public CommonResult<Boolean> deleteRentInfo(@RequestParam("id") Long id) {
        rentInfoService.deleteRentInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得车位租赁信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('park:rent-info:query')")
    public CommonResult<RentInfoRespVO> getRentInfo(@RequestParam("id") Long id) {
        RentInfoDO rentInfo = rentInfoService.getRentInfo(id);
        return success(BeanUtils.toBean(rentInfo, RentInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得车位租赁信息分页")
    @PreAuthorize("@ss.hasPermission('park:rent-info:query')")
    public CommonResult<PageResult<RentInfoRespVO>> getRentInfoPage(@Valid RentInfoPageReqVO pageReqVO) {
        PageResult<RentInfoDO> pageResult = rentInfoService.getRentInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, RentInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出车位租赁信息 Excel")
    @PreAuthorize("@ss.hasPermission('park:rent-info:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRentInfoExcel(@Valid RentInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<RentInfoDO> list = rentInfoService.getRentInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "车位租赁信息.xls", "数据", RentInfoRespVO.class,
                        BeanUtils.toBean(list, RentInfoRespVO.class));
    }

}