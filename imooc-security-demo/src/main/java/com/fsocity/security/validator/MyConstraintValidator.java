package com.fsocity.security.validator;

import com.fsocity.security.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zail
 * @since 2017-12-26
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
  
  @Autowired
  private HelloService helloService;
  
  @Override
  public void initialize(MyConstraint constraintAnnotation) {
    System.out.println("my validator init.");
  }
  
  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    
    System.out.println(value);
    helloService.greeting("zail");
    
    return false;
  }
}
