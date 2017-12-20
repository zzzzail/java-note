package spring4.AOP.helloworld;

/**
 * @author zail
 * @since 2017-12-20
 */
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {
  
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
