package com.longxingyang.enums;

import lombok.Getter;

/**
 * Created by a4420 on 18/01/23.
 */
@Getter
public enum AccountStatusEnum implements CodeEnum{
    NORMAL(0, "正常"),
    CANCEL(1, "停用"),
    ;

    private Integer code;

    private String message;

     AccountStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
