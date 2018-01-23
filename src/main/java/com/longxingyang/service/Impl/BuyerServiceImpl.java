package com.longxingyang.service.Impl;

import com.longxingyang.dto.OrderDTO;
import com.longxingyang.enums.ResultEnum;
import com.longxingyang.exception.SellException;
import com.longxingyang.service.BuyerService;
import com.longxingyang.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

/**
 * Created by a4420 on 18/01/08.
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String userId, String orderId) {
        return checkOrderOwner(userId, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String userId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(userId, orderId);
        if (orderDTO == null){
            log.error("[取消订单]查不到该订单， orderID={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String userId, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            return null;
        }
        if (!orderDTO.getUserId().equalsIgnoreCase(userId)){
            log.error("[查询订单]订单的userId不一致，userId={}, orderDTO={}",userId, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }

}
