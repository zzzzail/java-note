package spring4.AOP.impl;

import org.springframework.stereotype.Component;

/**
 * @author zail
 * @since 2017-12-20
 */
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
  @Override
  public Integer add(Integer i, Integer j) {
    Integer result = i + j;
    return result;
  }
  
  @Override
  public Integer subtract(Integer i, Integer j) {
    Integer result = i - j;
    return result;
  }
  
  @Override
  public Integer multiply(Integer i, Integer j) {
    Integer result = i * j;
    return result;
  }
  
  @Override
  public Integer divide(Integer i, Integer j) {
    Integer result = i / j;
    return result;
  }
}
