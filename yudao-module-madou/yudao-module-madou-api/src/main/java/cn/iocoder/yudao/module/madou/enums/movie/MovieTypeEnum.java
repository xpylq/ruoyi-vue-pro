package cn.iocoder.yudao.module.madou.enums.movie;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieTypeEnum {

    SELF("self", "自拍"),
    ;
    private final String code;
    private final String desc;
}
