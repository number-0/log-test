package com.shl.log.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * log4j2的日志门面使用slf4j
 *
 * @author songhengliang
 * @date 2020/5/31
 */
public class Slf4jTest {

  public static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

  /**
   * log4j2的日志门面使用slf4j
   * @throws Exception
   */
  @Test
  public void quickStart() throws Exception {
    // 日志输出
    LOGGER.error("error");
    LOGGER.warn("wring");
    LOGGER.info("info");
    LOGGER.debug("debug");
    LOGGER.trace("trace");
  }

  /**
   * XmlConfiguration#start(AbstractConfiguration#start())
   * 执行逻辑：
   *
   */
  public static void main(String[] args) {

  }
}
