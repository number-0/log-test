package com.shl.log.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/**
 * @author songhengliang
 * @date 2020/5/23
 */
public class Log4jTest {

  /**
   * 快速使用
   */
  @Test
  public void quickStart() throws Exception {
    // 开启 log4j 内置日志记录
    LogLog.setInternalDebugging(true);

    /*
    没有配置文件，会报如下warn信息，所以需要BasicConfigurator.configure();
      log4j:WARN No appenders could be found for logger (com.shl.log.log4j.Log4jTest).
      log4j:WARN Please initialize the log4j system properly.
     */
    // 初始化配置信息，暂不使用配置文件
//    BasicConfigurator.configure();

    // 获取日志记录器对象
    Logger logger = Logger.getLogger(com.shl.log.log4j.Log4jTest.class);
    // 日志记录输出
    logger.info("hello log4j");

    //for (int i = 0; i < 10000; i++) {

    // 日志级别
    logger.fatal("fatal"); // 严重错误，一般会造成系统崩溃并终止运行
    logger.error("error"); // 错误信息，不会影响系统运行
    logger.warn("warn");   // 警告信息，可能会发生问题
    logger.info("info");   // 运行信息，数据连接、网络连接、IO 操作等等
    logger.debug("debug"); // 调试信息，一般在开发中使用，记录程序变量参数传递信息等等
    logger.trace("trace"); // 追踪信息，记录程序所有的流程信息

    //}

    // 再创建一个日志记录器对象
    Logger logger1 = Logger.getLogger(Logger.class);
    logger1.fatal("fatal logger1"); // 严重错误，一般会造成系统崩溃并终止运行
    logger1.error("error logger1"); // 错误信息，不会影响系统运行
    logger1.warn("warn logger1");   // 警告信息，可能会发生问题
    logger1.info("info logger1");   // 运行信息，数据连接、网络连接、IO 操作等等
    logger1.debug("debug logger1"); // 调试信息，一般在开发中使用，记录程序变量参数传递信息等等
    logger1.trace("trace logger1"); // 追踪信息，记录程序所有的流程信息
  }

  /**
   * 自定义logger
   */
  @Test
  public void testCustomLogger() throws Exception {
    //自定义logger：com.shl
    Logger logger = Logger.getLogger(com.shl.log.log4j.Log4jTest.class);
    logger.info("hello log4j");
    logger.fatal("fatal");
    logger.error("error");
    logger.warn("warn");
    logger.info("info");
    logger.debug("debug");
    logger.trace("trace");


    //自定义logger：org.apache
    Logger logger2 = Logger.getLogger(org.apache.log4j.Logger.class);
    logger2.info("hello log4j");
    logger2.fatal("fatal");
    logger2.error("error");
    logger2.warn("warn");
    logger2.info("info");
    logger2.debug("debug");
    logger2.trace("trace");
  }
}
