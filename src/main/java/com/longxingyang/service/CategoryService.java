package com.longxingyang.service;

import com.longxingyang.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by a4420 on 17/11/24.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
