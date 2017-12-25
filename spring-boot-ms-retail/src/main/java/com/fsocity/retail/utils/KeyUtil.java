package com.fsocity.retail.utils;

import java.util.Random;

/**
 * @author zail
 * @version imp01.0.0
 */
public class KeyUtil {

  /**
   * 生成唯一主键
   * 格式: 时间 + 随机数
   * @return
   */
  public static synchronized String generatorUniqueKey() {
    Random random = new Random();
    Integer number = random.nextInt(900000) + 100000;
    return System.currentTimeMillis() + String.valueOf(number);
  }

}
