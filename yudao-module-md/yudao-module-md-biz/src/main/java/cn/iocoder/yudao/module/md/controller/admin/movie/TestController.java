package cn.iocoder.yudao.module.md.controller.admin.movie;


import cn.hutool.core.codec.Base64;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.json.JsonUtils;
import cn.iocoder.yudao.framework.encrypt.AesComponent;
import cn.iocoder.yudao.framework.encrypt.RsaComponent;
import cn.iocoder.yudao.framework.encrypt.core.annotation.ApiEncrypt;
import cn.iocoder.yudao.module.md.dal.dataobject.movie.MovieDO;
import cn.iocoder.yudao.module.md.utils.MockUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

import java.util.ArrayList;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Slf4j
@Tag(name = "APP-MD-测试")
@RestController
@RequestMapping("/md/test")
@Validated
@Profile({"local", "dev"})
public class TestController {
    @Autowired
    private RsaComponent rsaComponent;

    @Autowired
    private AesComponent aesComponent;

    @PermitAll
    @GetMapping("/base64")
    public CommonResult<String> base64() {
        MovieDO movie = MockUtils.mockMovie();
        String base64Encrypt = Base64.encode(JsonUtils.toJsonString(movie));
        String base64Decrypt = Base64.decodeStr(base64Encrypt);
        log.info("原始内容:{}", JsonUtils.toJsonString(movie));
        log.info("base64加密后:{}", base64Encrypt);
        log.info("base64解密后:{}", base64Decrypt);
        return success(base64Encrypt);
    }

    @PermitAll
    @GetMapping("/rsa")
    public CommonResult<String> rsa() {
        MovieDO movie = MockUtils.mockMovie(0);
        String encryptData = rsaComponent.encrypt(MockUtils.mockMovie());
        log.info("原始内容:{}", JsonUtils.toJsonString(movie));
        log.info("加密后:{}", encryptData);
        log.info("解密:{}", JsonUtils.toJsonString(rsaComponent.decrypt(encryptData, MovieDO.class)));
        return success(encryptData);
    }

    @PermitAll
    @GetMapping("/aes")
    public CommonResult<String> aes() {
        MovieDO movie = MockUtils.mockMovie();
        String encryptData = aesComponent.encrypt(MockUtils.mockMovie());
        log.info("原始内容:{}", JsonUtils.toJsonString(movie));
        log.info("加密后:{}", encryptData);
        log.info("解密:{}", JsonUtils.toJsonString(aesComponent.decrypt(encryptData, MovieDO.class)));
        return success(encryptData);
    }

    @PermitAll
    @GetMapping("/aesAnno")
    @ApiEncrypt
    public CommonResult<PageResult<MovieDO>> aesList() {
        PageResult<MovieDO> result = new PageResult();
        result.setTotal(3L);
        List<MovieDO> list = new ArrayList<>();
        list.add(MockUtils.mockMovie(0));
        list.add(MockUtils.mockMovie(1));
        list.add(MockUtils.mockMovie(2));
        result.setList(list);
        return success(result);
    }
}
