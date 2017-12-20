package spring4.AOP.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
   * 声明切入点表达式
   */
  @Pointcut("execution(* spring4.AOP.impl.ArithmeticCalculatorImpl.*(..))")
  public void declareJoinPointExpression() {}
  
  /**
   * 声明该方法是一个前置通知: 在目标方法开始之前执行
   */
  @Before(value = "declareJoinPointExpression()")
  public void beforeMethod(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    List<Object> args = Arrays.asList(joinPoint.getArgs());
    System.out.println("The method " +  methodName + " begins " + args);
  }
  
  /**
   * 后置通知: 在目标方法执行后(无论异常是否抛出异常), 执行的通知.
   * 在后置通知中还不能访问目标方法执行的结果.
   */
  @After(value = "declareJoinPointExpression()")
  public void afterMethod(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    System.out.println("The method " +  methodName + " ends ");
  }
  
  /**
   * 后置返回通知: 在目标方法正常结束后执行的通知.
   * 可以正常访问到方法的返回值.
   */
  @AfterReturning(value = "declareJoinPointExpression()", returning = "result")
  public void afterReturningMethod(JoinPoint joinPoint, Object result) {
    String methodName = joinPoint.getSignature().getName();
    System.out.println("The method " + methodName + " ends with " + result);
  }
  
  /**
   * 后置异常通知: 在目标方法抛出异常后执行的通知.
   * 可以访问到异常对象, 且可以指定在出现特定异常是所执行的通知.
   */
  @AfterThrowing(value = "declareJoinPointExpression()", throwing = "e")
  public void afterThrowingMethod(JoinPoint joinPoint, Exception e) {
    String methodName = joinPoint.getSignature().getName();
    System.out.println("The method " + methodName + " ends exception: " + e);
  }
  
  /**
   * 环绕通知需要携带 ProceedingJoinPoint 类型的参数.
   * 环绕通知: 类似于动态代理的全过程, ProceedingJoinPoint 类型的参数可以决定是否执行目标方法,
   * 且环绕通知必须有返回值, 返回值即为目标方法的返回值.
   */
  @Around(value = "declareJoinPointExpression()")
  public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
    // System.out.println("around...");
    
    // 执行目标方法
    Object result = null;
    try {
      // @Before 通知在这里执行
      result = proceedingJoinPoint.proceed();
      // @After 通知在这里执行
    }
    catch (Throwable throwable) {
      throwable.printStackTrace();
      // @AfterThrowing 通知在这里执行
      throw new RuntimeException(throwable);
    }
    
    // @AfterReturning 通知在这里执行
    
    return result;
  }
  
}
