package com.longxingyang.service.Impl;

import com.longxingyang.converter.UserInfo2UserInfoDTOConverter;
import com.longxingyang.dataobject.UserInfo;
import com.longxingyang.dto.UserInfoDTO;
import com.longxingyang.repository.UserInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by a4420 on 18/01/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {
    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private UserInfoServiceImpl service;

    @Test
    public void save() throws Exception {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUsername("张三");
        userInfoDTO.setAccountType("0");
        userInfoDTO.setUserPhone("13798957774");
        userInfoDTO.setPassword("123456");
        Assert.assertNotNull(service.save(userInfoDTO));
    }

    @Test
    public void findOne() throws Exception {
        UserInfoDTO userInfoDTO = service.findOne("1402020043");
        Assert.assertEquals("1402020043",userInfoDTO.getUserId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<UserInfoDTO> userInfoDTOPage = service.findList(request);
        //System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, userInfoDTOPage.getTotalElements());
    }

    @Test
    public void disable() throws Exception {
        UserInfo userInfo = repository.findOne("1402020044");
        UserInfoDTO userInfoDTO = UserInfo2UserInfoDTOConverter.convert(userInfo);
        service.disable(userInfoDTO);
        System.out.print(userInfoDTO);
    }

    @Test
    public void enable() throws Exception {
        UserInfo userInfo = repository.findOne("1402020044");
        UserInfoDTO userInfoDTO = UserInfo2UserInfoDTOConverter.convert(userInfo);
        service.enable(userInfoDTO);
        System.out.print(userInfoDTO);
    }

}