package com.longxingyang.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.longxingyang.dataobject.OrderDetail;
import com.longxingyang.dto.OrderDTO;
import com.longxingyang.enums.ResultEnum;
import com.longxingyang.exception.SellException;
import com.longxingyang.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a4420 on 17/12/10.
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUsername(orderForm.getName());
        orderDTO.setDesknum(orderForm.getDesknum());;
        orderDTO.setUserId(orderForm.getUserId());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){
                    }.getType());
        } catch (JsonSyntaxException e) {
            log.error("【对象转换】错误， string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
