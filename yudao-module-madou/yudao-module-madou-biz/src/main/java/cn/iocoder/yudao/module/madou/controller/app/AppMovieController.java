package cn.iocoder.yudao.module.madou.controller.app;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;


@Tag(name = "用户 App - Test")
@RestController
@RequestMapping("/movie/test")
@Validated
public class AppMovieController {
    @GetMapping("/get")
    @Operation(summary = "获取 test 信息")
    @PermitAll
    public CommonResult<String> get() {
        return CommonResult.success("true");
    }
}
