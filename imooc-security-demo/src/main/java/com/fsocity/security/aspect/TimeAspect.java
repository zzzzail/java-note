package com.fsocity.security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zail
 * @since 2017-12-26
 */
@Aspect
@Component
public class TimeAspect {
  
  @Around(value = "execution(* com.fsocity.security.controller.*.*(..))")
  public Object handleControllerMethod(ProceedingJoinPoint point) throws Throwable {
    System.out.println("time aspect start");
  
    Object[] args = point.getArgs();
    for (Object arg : args) {
      System.out.println("arg is " + arg);
    }
    
    long start = new Date().getTime();
    Object object = point.proceed();
    System.out.println("time aspect 耗时: " + (new Date().getTime() - start));
    
    System.out.println("time aspect end");
    return object;
  }

}
