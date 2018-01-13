package com.longxingyang.form;

import lombok.Data;

import java.math.BigDecimal;


/**
 * Created by a4420 on 18/01/13.
 */
@Data
public class ProductForm {

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
    private Integer categoryType;

    //商品描述
    private String productDescription;

}
