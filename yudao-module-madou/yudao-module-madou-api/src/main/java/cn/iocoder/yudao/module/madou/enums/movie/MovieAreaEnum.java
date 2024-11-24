package cn.iocoder.yudao.module.madou.enums.movie;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieAreaEnum {
    ASIA("asia", "亚洲"),
    ;
    private final String code;
    private final String desc;
}
