package com.shl.log.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * log4j2的日志门面使用log4j2-api
 *
 * @author songhengliang
 * @date 2020/5/31
 */
public class Log4j2Test {

  // 定义日志记录器对象
//  public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);

  static {
    System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
  }

  /**
   * log4j2的日志门面使用log4j2-api
   * @throws Exception 
   */
  @Test
  public void quickStart() throws Exception {
    Logger LOGGER = LoggerFactory.getLogger(Log4j2Test.class);

//    LOGGER.debug("debug .......");
    LOGGER.info("info ........");


    Thread.sleep(Integer.MAX_VALUE);
  }

  static {
    System.setProperty("logging.file.path", "/Users/songhengliang/java/workspace-shl/log-test/log4j2-test/log4j2-test");
    System.setProperty("project.name", "log4j2-test");
    System.setProperty("logging.console.level", "info");
  }

  @Test
  public void template() throws Exception {
    Logger LOGGER = LoggerFactory.getLogger(Log4j2Test.class);

    while(true) {
      Thread.sleep(5L);
      LOGGER.info("info ........");
      LOGGER.warn("info ........");
      LOGGER.error("info ........");
    }


//    Thread.sleep(Integer.MAX_VALUE);
  }
}
