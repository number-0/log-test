package com.shl.log.slf4j;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 桥接器测试
 * @author songhengliang
 * @date 2020/5/28
 */
public class Log4jTest {

  // 定义 log4j 日志记录器
  public static final Logger LOGGER = Logger.getLogger(Log4jTest.class);

  /**
   * 测试桥接器：将log4j替换成logback，但不修改原有代码
   *
   * 原来：只引入log4j进行日志输出
   *
   * 现在：移除log4j日志框架，引入slf4j-api、桥接器log4j-over-slf4j、logback
   *
   * @throws Exception
   */
  @Test
  public void test01()throws Exception{
    LOGGER.info("hello lgo4j");
  }

}
