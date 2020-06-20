package com.shl.log.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * log4j2的日志门面使用log4j2-api
 *
 * @author songhengliang
 * @date 2020/5/31
 */
public class Log4j2Test {

  // 定义日志记录器对象
//  public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);

  /**
   * log4j2的日志门面使用log4j2-api
   * @throws Exception 
   */
  @Test
  public void quickStart() throws Exception {
    Logger LOGGER = LoggerFactory.getLogger(Log4j2Test.class);

    // 日志消息输出
//    LOGGER.fatal("fatal");
    LOGGER.error("error");
    LOGGER.warn("warn");
    LOGGER.info("inf");
    LOGGER.debug("debug");
    LOGGER.trace("trace");
  }
}
