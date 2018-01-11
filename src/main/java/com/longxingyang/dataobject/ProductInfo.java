package com.longxingyang.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.longxingyang.enums.ProductStatusEnum;
import com.longxingyang.utils.EnumUtil;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * Created by a4420 on 17/11/25.
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    //名字
    private String productName;

    //单价
    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    //商品小图
    private String productIcon;

    //商品类目
    private Integer gategoryType;

    //商品描述
    private String productDescription;

    //商品状态 0正常1下架
    private Integer productStatus;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
