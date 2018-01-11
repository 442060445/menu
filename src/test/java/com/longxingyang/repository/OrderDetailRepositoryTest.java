package com.longxingyang.repository;

import com.longxingyang.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by a4420 on 17/12/03.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("201712031002");
        orderDetail.setOrderId("201712030001");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("123459");
        orderDetail.setProductName("牛扒套餐");
        orderDetail.setProductPrice(new BigDecimal(10));
        orderDetail.setProductQuantity(1);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("201712030001");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}