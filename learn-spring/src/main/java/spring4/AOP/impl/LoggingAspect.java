package spring4.AOP.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 日志切面
 * 把该类声明为一个切面:
 *   1. 把该类放入到IOC容器中
 *   2. 再声明为一个切面
 *   3.
 * @author zail
 * @since 2017-12-20
 */
@Component
@Aspect
public class LoggingAspect {
  
  /**
   * 声明该方法是一个前置通知: 在目标方法开始之前执行
   */
  @Before(value = "execution(* spring4.AOP.impl.ArithmeticCalculatorImpl.*(..))", argNames = "")
  public void beforeMethod(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    List<Object> args = Arrays.asList(joinPoint.getArgs());
    System.out.println("The method " +  methodName + " begins " + args);
  }
  
  /**
   * 后置通知: 在目标方法执行后(无论异常是否抛出异常), 执行的通知.
   * 在后置通知中还不能访问目标方法执行的结果.
   * @param joinPoint
   */
  @After(value = "execution(* spring4.AOP.impl.ArithmeticCalculatorImpl.*(..))", argNames = "")
  public void afterMethod(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    System.out.println("The method " +  methodName + " ends ");
  }
  
  @AfterReturning(value = "execution(* spring4.AOP.impl.ArithmeticCalculatorImpl.*(..))", returning = "result")
  public void afterReturningMethod(JoinPoint joinPoint, Object result) {
    String methodName = joinPoint.getSignature().getName();
    System.out.println("The method " + methodName + " ends with " + result);
  }
  
  @AfterThrowing(value = "execution(* spring4.AOP.impl.ArithmeticCalculatorImpl.*(..))", throwing = "e")
  public void afterThrowingMethod(JoinPoint joinPoint, Exception e) {
    String methodName = joinPoint.getSignature().getName();
    System.out.println("The method " + methodName + " ends exception: " + e);
  }
  
}
