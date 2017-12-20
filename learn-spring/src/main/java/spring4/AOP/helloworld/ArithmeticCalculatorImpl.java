package spring4.AOP.helloworld;

/**
 * @author zail
 * @since 2017-12-20
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
  @Override
  public Integer add(Integer i, Integer j) {
    System.out.println("The method add begins with[" + i +  ", " + j + "]");
    Integer result = i + j;
    System.out.println("The method add ends with[" + i +  ", " + j + "]");
    return result;
  }
  
  @Override
  public Integer subtract(Integer i, Integer j) {
    System.out.println("The method subtract begins with[" + i +  ", " + j + "]");
    Integer result = i - j;
    System.out.println("The method subtract ends with[" + i +  ", " + j + "]");
    return result;
  }
  
  @Override
  public Integer multiply(Integer i, Integer j) {
    System.out.println("The method multiply begins with[" + i +  ", " + j + "]");
    Integer result = i * j;
    System.out.println("The method multiply ends with[" + i +  ", " + j + "]");
    return result;
  }
  
  @Override
  public Integer divide(Integer i, Integer j) {
    System.out.println("The method divide begins with[" + i +  ", " + j + "]");
    Integer result = i / j;
    System.out.println("The method divide ends with[" + i +  ", " + j + "]");
    return result;
  }
}
