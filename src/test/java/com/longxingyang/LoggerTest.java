package com.longxingyang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by a4420 on 17/11/06.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void Test1(){
        logger.error("error...");
        logger.debug("debug...");
        logger.info("info....");
        logger.warn("warn...");

    }
}
