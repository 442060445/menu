package com.longxingyang.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by a4420 on 17/11/25.
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
