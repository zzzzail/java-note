package spring4.AOP.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zail
 * @since 2017-12-20
 *
 * @EnableAspectJAutoProxy 使AspectJ注解起作用: 自动为匹配的类生成代理对象
 */
@ComponentScan
@EnableAspectJAutoProxy
public class Main {
  
  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
    ArithmeticCalculator ac = ctx.getBean(ArithmeticCalculator.class);
    
    Integer result = ac.add(10, 20);
    System.out.println(result);
    result = ac.multiply(10, 20);
    System.out.println(result);
    result = ac.divide(100, 10);
    System.out.println(result);
  }
  
}
