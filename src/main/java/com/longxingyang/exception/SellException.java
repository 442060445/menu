package com.longxingyang.exception;

import com.longxingyang.enums.ResultEnum;

/**
 * Created by a4420 on 17/12/05.
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);

        this.code = code;
    }
}
