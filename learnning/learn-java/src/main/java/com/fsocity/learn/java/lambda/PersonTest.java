package com.fsocity.learn.java.lambda;

import com.fsocity.learn.java.Converter;
import org.junit.Test;

/**
 * @author zail
 * @since 2018-06-08
 */
public class PersonTest {
    
    @Test
    public void testPersonFactory() {
        PersonFactory<Person> personPersonFactory = Person::new;
        Person person = personPersonFactory.create("zail", "zhang");
        System.out.println(person);
    }
    
    // 访问局部变量
    @Test
    public void testLambda1() {
        /**
         * Lambda 表达式内部可以访问到外部的 final 局部变量
         * num 并不一定是 final 的
         * 不加 final 的时候, num 被隐式地当做 final 变量来处理
         * 改变 num 的值是不允许的, Lambda 表达式中也不允许改变 num 的值.
         */
        int num = 1;
        Converter<Integer, String> converter = srouce -> String.valueOf(srouce + num);
        String result = converter.convert(2);
        System.out.println(result);
        
        // num = 2;
    }
    
    // 访问成员变量和静态变量
    @Test
    public void testLambda2() {
        Lambda4 lambda4 = new Lambda4();
        System.out.println(lambda4.outerNum);
        System.out.println(Lambda4.outerStaticNum);
        
        lambda4.testScope();
        
        System.out.println(lambda4.outerNum);
        System.out.println(Lambda4.outerStaticNum);
    }
    
    
    
}

class Lambda4 {
    
    static int outerStaticNum;
    
    int outerNum;
    
    void testScope() {
        /**
         * Lambda 表达式内容部可以改变成员变量与静态变量的值
         *
         */
        Converter<Integer, String> stringConverter1 = source -> {
            outerNum = 23;
            return String.valueOf(source);
        };
        
        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    
        // String result = stringConverter1.convert(1);
        // System.out.println("result = " + result);
        String result = stringConverter2.convert(2);
        System.out.println("result = " + result);
    }
}
