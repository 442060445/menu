package com.longxingyang.repository;

import com.longxingyang.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by a4420 on 17/12/03.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String USERID = "1402020044";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("201712030001");
        orderMaster.setUsername("单元测试");
        orderMaster.setDesknum("10");
        orderMaster.setUserId(USERID);
        orderMaster.setOrderAmount(new BigDecimal(19.9));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUserId() throws Exception {
        PageRequest request = new PageRequest(0, 3);

        Page<OrderMaster> result = repository.findByUserId(USERID, request);

        System.out.println(result.getTotalElements());

        Assert.assertNotEquals(0, result.getTotalElements());
    }


}