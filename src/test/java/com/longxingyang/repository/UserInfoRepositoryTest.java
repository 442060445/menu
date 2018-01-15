package com.longxingyang.repository;

import com.longxingyang.dataobject.UserInfo;
import com.longxingyang.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by a4420 on 18/01/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository repository;

    @Test
    public void save(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(KeyUtil.genUniqueKey());
        userInfo.setUsername("admin");
        userInfo.setPassword("admin");
        userInfo.setOpenid("1402020001");

        UserInfo result = repository.save(userInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOpenid() throws Exception {
        UserInfo result = repository.findByOpenid("1402020001");
        Assert.assertEquals("1402020001", result.getOpenid());
    }

}