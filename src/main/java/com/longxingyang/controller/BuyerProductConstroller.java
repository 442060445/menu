package com.longxingyang.controller;

import com.longxingyang.VO.ProductInfoVO;
import com.longxingyang.VO.ProductVO;
import com.longxingyang.VO.ResultVO;
import com.longxingyang.dataobject.ProductCategory;
import com.longxingyang.dataobject.ProductInfo;
import com.longxingyang.service.CategoryService;
import com.longxingyang.service.ProductService;
import com.longxingyang.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 买家商品controller
 * Created by a4420 on 17/11/26.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductConstroller {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1、查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2、查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        for(ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3、数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }


        return ResultVOUtils.success(productVOList);

    }
}
