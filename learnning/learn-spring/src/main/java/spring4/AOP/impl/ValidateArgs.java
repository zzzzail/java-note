package spring4.AOP.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zail
 * @since 2017-12-20
 * @Order 指定组件的优先级, 值越小优先级越高
 */
@Component
@Aspect
@Order(1)
public class ValidateArgs {
  
  @Before("LoggingAspect.declareJoinPointExpression()")
  public void validateArgs(JoinPoint joinPoint) {
    System.out.println("validateArgs");
  }
  
}
