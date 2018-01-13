package com.longxingyang.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by a4420 on 17/11/08.
 * Product_Category
 * 类目
 */
//@Table(name = "数据库表名")
@Entity
//动态同步
@DynamicUpdate
//省去写get和set方法
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private  Integer categoryId;

    //类目名字
    private  String categoryName;

    //类目编号
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
