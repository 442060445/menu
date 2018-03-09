package com.longxingyang.service.Impl;

import com.longxingyang.dto.EvaluateDTO;
import com.longxingyang.service.EvaluateService;
import com.longxingyang.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
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
 * Created by a4420 on 18/02/09.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluateServiceImplTest {
    @Autowired
    private EvaluateService evaluateService;

    @Test
    public void create() throws Exception {
        EvaluateDTO evaluateDTO = new EvaluateDTO();
        evaluateDTO.setUsername("单元测试3");
        evaluateDTO.setEvaluateId(KeyUtil.genUniqueKey());
        evaluateDTO.setRating(1);
        evaluateDTO.setContent("评论内容");
        evaluateDTO.setUserId("123456");
        EvaluateDTO result = evaluateService.create(evaluateDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 10);
        Page<EvaluateDTO> evaluateDTOPage = evaluateService.findList(request);
        System.out.println(evaluateDTOPage.getTotalElements());
        Assert.assertNotEquals(0,evaluateDTOPage.getTotalElements());
    }

    @Test
    public void findListByUserId() throws Exception {
        PageRequest request = new PageRequest(0, 10);
        Page<EvaluateDTO> evaluateDTOPage = evaluateService.findListByUserId("123456", request);
        System.out.println(evaluateDTOPage.getTotalElements());
        Assert.assertNotEquals(0, evaluateDTOPage.getTotalElements());
    }

}