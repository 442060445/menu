package com.longxingyang.service;

import com.longxingyang.dto.OrderDTO;

/**
 * Created by a4420 on 18/01/01.
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String userId, String orderId);

    //取消订单
    OrderDTO cancelOrder(String userId, String orderId);
}
