package com.fsocity.learn.java.lambda;

/**
 * @author zail
 * @since 2018-06-08
 */
@FunctionalInterface
public interface PersonFactory<P extends Person> {
    
    P create(String firstName, String lastName);
    
}
