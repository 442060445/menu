package com.longxingyang.service;

import com.longxingyang.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by a4420 on 17/12/05.
 */
public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询单个订单
    OrderDTO findOne(String orderId);

    //查询订单列表
    Page<OrderDTO> findList(String userId, Pageable pageable);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish (OrderDTO orderDTO);

    //支付订单
    OrderDTO paid (OrderDTO orderDTO);

    //查询订单列表
    Page<OrderDTO> findList(Pageable pageable);

}
