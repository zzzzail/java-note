package spring4.AOP.impl;

/**
 * @author zail
 * @since 2017-12-20
 */
public interface ArithmeticCalculator {
  
  /**
   * 加法
   * @param i
   * @param j
   * @return i + j
   */
  Integer add(Integer i, Integer j);
  
  /**
   * 减法
   * @param i
   * @param j
   * @return i - j
   */
  Integer subtract(Integer i, Integer j);
  
  /**
   * 乘法
   * @param i
   * @param j
   * @return i * j
   */
  Integer multiply(Integer i, Integer j);
  
  /**
   * 除法
   * @param i
   * @param j
   * @return i / j
   */
  Integer divide(Integer i, Integer j);
  
}
