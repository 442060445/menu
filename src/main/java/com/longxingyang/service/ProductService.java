package com.longxingyang.service;

import com.longxingyang.dataobject.ProductInfo;
import com.longxingyang.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by a4420 on 17/11/25.
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    //查询在架商品
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架商品
    ProductInfo onSale(String productId);

    //下架商品
    ProductInfo offSale(String productId);
}
