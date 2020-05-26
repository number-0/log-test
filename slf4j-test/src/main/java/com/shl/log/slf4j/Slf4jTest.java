package com.shl.log.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author songhengliang
 * @date 2020/5/25
 */
public class Slf4jTest {

  public static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

  /**
   * 门面：slf4j
   * 日志实现：slf4j-simple，是slf4j内置的简单日志实现框架
   * @throws Exception
   */
  @Test
  public void test01()throws Exception{
    // 日志输出
    LOGGER.error("error");
    LOGGER.warn("wring");
    LOGGER.info("info"); // 默认级别
    LOGGER.debug("debug");
    LOGGER.trace("trace");

    // 使用占位符输出日志信息
    String name = "itheima";
    Integer age = 14;
    LOGGER.info("用户：{},{}",name,age);

    // 将系统的异常信息输出
    try {
      int i = 1/0;
    } catch (Exception e) {
      // e.printStackTrace();
      LOGGER.error("出现异常：",e);

    }
  }



}
