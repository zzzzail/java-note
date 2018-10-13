package com.fsocity.security.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 我的约束注解
 * @author zail
 * @since 2017-12-26
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
  
  String message() default "{com.fsocity.security.validator.MyConstraint.message}";
  
  Class<?>[] groups() default { };
  
  Class<? extends Payload>[] payload() default { };

}
