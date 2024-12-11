package cn.iocoder.yudao.module.md.controller.admin.movie;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.md.controller.admin.movie.vo.*;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import cn.iocoder.yudao.module.md.service.movie.MovieService;

@Tag(name = "管理后台-MD-影片")
@RestController
@RequestMapping("/md/movie")
@Validated
public class MovieController {

    @Resource
    private MovieService movieService;

    @PostMapping("/create")
    @Operation(summary = "创建影片")
    @PreAuthorize("@ss.hasPermission('md:movie:create')")
    public CommonResult<Long> createMovie(@Valid @RequestBody MovieSaveReqVO createReqVO) {
        return success(movieService.createMovie(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新影片")
    @PreAuthorize("@ss.hasPermission('md:movie:update')")
    public CommonResult<Boolean> updateMovie(@Valid @RequestBody MovieSaveReqVO updateReqVO) {
        movieService.updateMovie(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除影片")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('md:movie:delete')")
    public CommonResult<Boolean> deleteMovie(@RequestParam("id") Long id) {
        movieService.deleteMovie(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得影片")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('md:movie:query')")
    public CommonResult<MovieRespVO> getMovie(@RequestParam("id") Long id) {
        MovieDO movie = movieService.getMovie(id);
        return success(BeanUtils.toBean(movie, MovieRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得影片分页")
    @PreAuthorize("@ss.hasPermission('md:movie:query')")
    public CommonResult<PageResult<MovieRespVO>> getMoviePage(@Valid MoviePageReqVO pageReqVO) {
        PageResult<MovieDO> pageResult = movieService.getMoviePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MovieRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出影片 Excel")
    @PreAuthorize("@ss.hasPermission('md:movie:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportMovieExcel(@Valid MoviePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MovieDO> list = movieService.getMoviePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "影片.xls", "数据", MovieRespVO.class,
                        BeanUtils.toBean(list, MovieRespVO.class));
    }
}