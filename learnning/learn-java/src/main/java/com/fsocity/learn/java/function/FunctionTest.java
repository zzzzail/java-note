package com.fsocity.learn.java.function;

import com.fsocity.learn.java.lambda.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author zail
 * @since 2018-06-08
 */
public class FunctionTest {
    
    @Test
    public void testFunction1() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Integer result = toInteger.apply("1");
        System.out.println(result);
        
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        String s = backToString.apply("123");
        System.out.println(s);
    }
    
    @Test
    public void testSupplier() {
        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get();
        System.out.println(person);
    }
    
    @Test
    public void testConsumer() {
        Consumer<Person> greeter = p -> System.out.println("Hello, " + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));
    }
    
    @Test
    public void testOptional() {
        Optional<String> optional = Optional.of("bam");
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("fallback"));
        optional.ifPresent(s -> System.out.println(s.charAt(0)));
    }
    
    @Test
    public void testStream() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    
        // stringCollection.stream()
        //     .filter(s -> s.startsWith("a"))
        //     .map(String::toUpperCase)
        //     .sorted()
        //     .forEach(System.out::println);
        
        boolean flag1 = stringCollection
            .stream()
            .anyMatch(s -> s.startsWith("a"));
        System.out.println(flag1);
        
        boolean flag2 = stringCollection
            .stream()
            .allMatch(s -> s.startsWith("a"));
        System.out.println(flag2);
        
        boolean flag3 = stringCollection
            .stream()
            .noneMatch(s -> s.startsWith("z"));
        System.out.println(flag3);
    }
}
