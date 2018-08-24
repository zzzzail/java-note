package com.fsocity.learn.java.lambda;

import lombok.Data;

/**
 * @author zail
 * @since 2018-06-08
 */
@Data
public class Person {
    
    private String firstName;
    
    private String lastName;
    
    public Person() {
    }
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return "Person{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}
