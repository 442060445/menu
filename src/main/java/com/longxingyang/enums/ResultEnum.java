package com.longxingyang.enums;

import lombok.Getter;

/**
 * Created by a4420 on 17/12/05.
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数不正确"),

    PRODUCT_NOT_EXIST(404, "商品不存在"),

    PRODUCT_STOCK_ERROR(11, "库存不正确"),

    ORDER_NOT_EXIST(12, "订单不存在"),

    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),

    ORDER_STATUS_ERROR(14, "订单状态不正确"),

    ORDER_UPDATE_FAIL(15, "订单更新失败"),

    ORDER_DETAIL_EMPTY(16, "订单详情为空"),

    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),

    CART_EMPTY(18, "购物车为空"),

    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),

    ORDER_CANCEL_SUCCESS(20, "订单取消成功"),

    ORDER_FINISH_SUCCESS(21, "订单完结成功"),

    PRODUCT_STATUS_ERROR(22, "商品状态不正确"),

    LOGIN_FAIL(23, "登录失败, 登录信息不正确"),

    LOGOUT_SUCCESS(24, "登出成功"),

    PRODUCT_UPDATE_SUCCESS(25, "商品状态更新成功"),

    ACCOUNT_STATUS_ERROR(26, "帐号状态异常"),

    ACCOUNT_UPDATE_FAIL(27, "帐号更新失败"),

    ACCOUNT_UPDATE_SUCCESS(28, "帐号更新成功"),

    LOGIN_SUCCESS(29, "登陆成功"),

    NO_RIGHT(29, "非管理员帐号不能登录")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
