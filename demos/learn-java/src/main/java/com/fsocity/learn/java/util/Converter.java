package com.fsocity.learn.java.util;

/**
 * @author zail
 * @since 2018-07-08
 */
@FunctionalInterface
public interface Converter<S, T> {
  
  /**
   * 转换
   * @param source
   * @return
   */
  T convert(S source);
  
}
