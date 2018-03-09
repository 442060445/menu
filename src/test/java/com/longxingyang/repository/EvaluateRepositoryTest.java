package com.longxingyang.repository;

import com.longxingyang.dataobject.Evaluate;
import com.longxingyang.dto.EvaluateDTO;
import com.longxingyang.utils.KeyUtil;
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
public class EvaluateRepositoryTest {
    @Autowired
    private EvaluateRepository evaluateRepository;

    @Test
    public void findByUserId() throws Exception {
        PageRequest request = new PageRequest(0, 3);
        Page<Evaluate> result = evaluateRepository.findByUserId("123456", request);
        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void save() throws Exception{
        Evaluate evaluate = new Evaluate();
        evaluate.setUserId("123456");
        evaluate.setEvaluateId(KeyUtil.genUniqueKey());
        evaluate.setContent("超级好吃");
        evaluate.setRating(10);
        evaluate.setUsername("单元测试2");
        Evaluate result = evaluateRepository.save(evaluate);
        Assert.assertNotNull(result);
    }

}