package com.longxingyang.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by a4420 on 17/12/03.
 */
@DynamicUpdate
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    //订单ID
    private String orderId;

    //商品ID
    private String productId;

    //商品名称
    private String productName;

    //商品单价
    private BigDecimal productPrice;

    //商品数量
    private Integer productQuantity;

    //商品小图
    private String productIcon;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;
}
