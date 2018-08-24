package com.fsocity.learn.java.lambda;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author zail
 * @since 2018-06-08
 */
public class Lambda5 {
    
    /**
     * Predicate是一个布尔类型的函数，该函数只有一个输入参数。
     * Predicate接口包含了多种默认方法，用于处理复杂的逻辑动词（and, or，negate）
     *
     */
    @Test
    public void testPredicate1() {
        Predicate<String> predicate = s -> s.length() > 0;
        boolean flag1 = predicate.test("foo");
        System.out.println(flag1);
        boolean flag2 = predicate.negate().test("foo");
        System.out.println(flag2);
    }
    
    @Test
    public void testPredicate2() {
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        
    }
    
}
