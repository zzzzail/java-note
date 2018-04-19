package spring4.AOP.helloworld;

/**
 * @author zail
 * @since 2017-12-20
 */
public class Main {
  
  public static void main(String[] args) {
  
    ArithmeticCalculator ac = new ArithmeticCalculatorLoggingImpl();
    ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(ac).getLoggingProxy();
    Integer result = proxy.add(10, 20);
    System.out.println(result);
    
    result = proxy.subtract(20, 10);
    System.out.println(result);
    
  }
  
}
