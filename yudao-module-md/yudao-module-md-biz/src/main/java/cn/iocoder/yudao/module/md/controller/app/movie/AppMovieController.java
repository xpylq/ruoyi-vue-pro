package cn.iocoder.yudao.module.md.controller.app.movie;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.md.controller.admin.movie.vo.MovieRespVO;
import cn.iocoder.yudao.module.md.controller.app.movie.vo.AppMoviePageReqVO;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import cn.iocoder.yudao.module.md.service.movie.MovieService;
import cn.iocoder.yudao.module.md.utils.HSexUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;


@Tag(name = "APP-MD-影片")
@RestController
@RequestMapping("/md/movie")
@Validated
public class AppMovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/page")
    @Operation(summary = "获得影片分页")
    @PermitAll
    public CommonResult<PageResult<MovieRespVO>> getMoviePage(@Valid AppMoviePageReqVO pageReqVO) {
        PageResult<MovieDO> pageResult = movieService.getMoviePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MovieRespVO.class));
    }

    @GetMapping("/detail")
    @Operation(summary = "获取影片详情")
    @PermitAll
    public CommonResult<String> getDetail(String refId) {
        String videoUrl = HSexUtils.parseVideoUrl(refId);
        return success(videoUrl);
    }
}
