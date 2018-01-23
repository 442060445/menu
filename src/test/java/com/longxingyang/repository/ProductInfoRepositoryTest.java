package com.longxingyang.repository;

import com.longxingyang.dataobject.ProductCategory;
import com.longxingyang.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by a4420 on 17/11/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Transactional
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("000002");
        productInfo.setProductName("米饭");
        productInfo.setProductPrice(new BigDecimal(1));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("这是一碗米饭");
        productInfo.setProductIcon("Http://xxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() throws Exception {
    }

}