package com.fsocity.retail;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zail
 * @version imp01.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

  @Test
  public void test1() {
    log.debug("debug");
    log.info("info...");
    log.error("error...");
  }

}
