package com.longxingyang.dataobject;

import com.longxingyang.enums.OrderStatusEnum;
import com.longxingyang.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * Created by a4420 on 17/12/03.
 */
//动态更新
@DynamicUpdate
@Entity
@Data
public class OrderMaster {

    //订单ID
    @Id
    private String orderId;

    //用户名
    private String username;

    //用户ID
    private String userId;

    //用餐桌号
    private  String desknum;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

}
