package com.shl.log.jul;

import java.io.InputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.junit.Test;

/**
 * @author songhengliang
 * @date 2020/5/23
 */
public class JulTest {

  /**
   * 快速使用
   */
  @Test
  public void quickStart() throws Exception {
    // 1.获取日志记录器对象
    Logger logger = Logger.getLogger("com.shl.log.jul.JulTest");
    // 2.日志记录输出
    logger.info("hello jul");

    // 通用方法进行日志记录
    logger.log(Level.INFO, "info msg");

    // 通过占位符 方式输出变量值
    String name = "jul";
    Integer age = 13;
    logger.log(Level.INFO, "userInfo：{0},{1}", new Object[]{name, age});

  }

  /**
   * 日志级别
   */
  @Test
  public void testLogLevel() throws Exception {
    // 1.获取日志记录器对象
    Logger logger = Logger.getLogger("com.shl.log.jul.JulTest");

    // 2.日志记录输出
    logger.severe("severe");
    logger.warning("warning");
    logger.info("info"); // 默认日志输出级别
    logger.config("config");
    logger.fine("fine");
    logger.finer("finer");
    logger.finest("finest");
  }

  /**
   * java代码修改日志级别：也可以使用配置文件
   */
  @Test
  public void testLogConfig() throws Exception {
    // 1.获取日志记录器对象
    Logger logger = Logger.getLogger("com.shl.log.jul.JulTest");

    // 关闭系统默认配置
    logger.setUseParentHandlers(false);

    // 自定义配置日志级别
    // 创建ConsoleHandler：控制台输出
    ConsoleHandler consoleHandler = new ConsoleHandler();

    // 创建简单格式转换对象
    SimpleFormatter simpleFormatter = new SimpleFormatter();

    // 进行关联
    consoleHandler.setFormatter(simpleFormatter);
    logger.addHandler(consoleHandler);

    // 配置日志具体级别
    logger.setLevel(Level.ALL);
    consoleHandler.setLevel(Level.ALL);

    // FileHandler：文件输出
    FileHandler fileHandler = new FileHandler(
        "/Users/workoffice/java/workspace-shl/log-test/jul-test/logs/jul.log");

    // 进行关联
    fileHandler.setFormatter(simpleFormatter);
    logger.addHandler(fileHandler);

    // 2.日志记录输出
    logger.severe("severe");
    logger.warning("warning");
    logger.info("info"); // 默认日志输出级别
    logger.config("config");
    logger.fine("fine");
    logger.finer("finer");
    logger.finest("finest");
  }

  /**
   * Logger对象父子关系
   *    如果没有设置logger，默认走LogManager$RootLogger，即root，rootLogger的name是空字符串""
   *    如果logger1没有设置日志级别，那么就会使用logger2的日志级别，如果logger1页没有设置日志级别，那么使用RootLogger的日志级别
   */
  @Test
  public void testLogParent() throws Exception {

    Logger logger1 = Logger.getLogger("com.shl");
    Logger logger2 = Logger.getLogger("com");

    // logger2是logger1的父logger
    System.out.println(logger1.getParent() == logger2);
    // 所有logger的顶级父logger：LogManager$RootLogger，顶级logger的name:""
    System.out.println(
        "logger2 Parent:" + logger2.getParent() + ", name:" + logger2.getParent().getName());

    // 关闭默认配置
    logger2.setUseParentHandlers(false);

    // 设置logger2日志级别
    // 自定义配置日志级别
    // 创建ConsoleHandler：控制台输出
    ConsoleHandler consoleHandler = new ConsoleHandler();

    // 创建简单格式转换对象
    SimpleFormatter simpleFormatter = new SimpleFormatter();

    // 进行关联
    consoleHandler.setFormatter(simpleFormatter);
    logger2.addHandler(consoleHandler);

    // 配置日志具体级别：logger1没有设置日志级别，就会使用logger2的日志级别
    logger2.setLevel(Level.ALL);
    consoleHandler.setLevel(Level.ALL);

    //logger1没有设置日志级别，就会使用logger2的日志级别
    //所以以下日志全部会输出
    logger1.severe("severe");
    logger1.warning("warning");
    logger1.info("info");
    logger1.config("config");
    logger1.fine("fine");
    logger1.finer("finer");
    logger1.finest("finest");
  }

  /**
   * 配置文件方式
   * @throws Exception
   */
  @Test
  public void testLogProperties()throws Exception{
    //start  手动加载配置文件，实际不需要手动去操作

    // 读取配置文件，通过类加载器
    InputStream ins = JulTest.class.getClassLoader().getResourceAsStream("logging.properties");
    // 创建LogManager
    LogManager logManager = LogManager.getLogManager();
    // 通过LogManager加载配置文件
    logManager.readConfiguration(ins);

    //end  手动加载配置文件，实际不需要手动去操作


    // 创建日志记录器
    Logger logger = Logger.getLogger("com.shl");
    logger.severe("severe");
    logger.warning("warning");
    logger.info("info");
    logger.config("config");
    logger.fine("fine");
    logger.finer("finer");
    logger.finest("finest");


    Logger logger2 = Logger.getLogger("test");
    logger2.severe("severe test");
    logger2.warning("warning test");
    logger2.info("info test");
    logger2.config("config test");
    logger2.fine("fine test");
    logger2.finer("finer test");
    logger2.finest("finest test");
  }


  /**
   * 源码分析
   * @throws Exception
   */
  @Test
  public void codeAnalysis()throws Exception{
    Logger logger = Logger.getLogger("com.shl");
    logger.severe("severe");
    logger.warning("warning");
    logger.info("info");
    logger.config("config");
    logger.fine("fine");
    logger.finer("finer");
    logger.finest("finest");


    Logger logger2 = Logger.getLogger("test");
    logger2.severe("severe test");
    logger2.warning("warning test");
    logger2.info("info test");
    logger2.config("config test");
    logger2.fine("fine test");
    logger2.finer("finer test");
    logger2.finest("finest test");
  }
}
