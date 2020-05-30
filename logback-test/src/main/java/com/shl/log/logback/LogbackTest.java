package com.shl.log.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author songhengliang
 * @date 2020/5/30
 */
public class LogbackTest {
  public static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

  /**
   *
   * @throws Exception
   */
  @Test
  public void quickStart() throws Exception {

    for (int i = 0; i < 10000; i++) {
      // 日志输出
      LOGGER.error("error");
      LOGGER.warn("wring");
      LOGGER.info("info");
      LOGGER.debug("debug");// 默认级别
      LOGGER.trace("trace");
    }

  }
}
