package com.longxingyang.dto;

import lombok.Data;

/**
 * Created by a4420 on 17/12/08.
 */
@Data
public class CartDTO {

    //商品ID
    private String productId;

    //商品数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
