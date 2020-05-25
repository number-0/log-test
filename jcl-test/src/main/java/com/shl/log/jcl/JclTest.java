package com.shl.log.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author songhengliang
 * @date 2020/5/25
 */
public class JclTest {

  @Test
  public void testQuick() throws Exception {
    // 获取 log日志记录器对象
    Log log = LogFactory.getLog(JclTest.class);

    // 日志记录输出
    log.info("hello jcl");
    log.fatal("fatal");
    log.error("error");
    log.warn("warn");
    log.info("info");
    log.debug("debug");
  }
}
